package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcompose.ui.theme.FirstComposeTheme
import com.example.firstcompose.ui.theme.StateManagement
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {

    var isOpen= mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PreviewFun()
        }
    }


@Preview( widthDp = 300, heightDp = 600)
    @Composable
    private fun PreviewFun()
    {
        Column(  modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            Surface(
                shadowElevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.background,

            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painterResource(id = androidx.core.R.drawable.notify_panel_notification_icon_bg),
                        contentDescription = "Dummy image",
                        colorFilter = ColorFilter.tint(
                            Color.Blue
                        ),
                        modifier = Modifier.size(60.dp)
                    )

                    Button(onClick = { isOpen.value = !isOpen.value }) {
                        Text(text = "Projects")
                    }
                    Divider()

                }


            }
            if (isOpen.value) {
                LazyColumn {
                    items(getProjectList()) {
                        ProjectItems(it)
                    }
                }
            }
        }
    }

    @Composable
    private fun ProjectItems (project:Project)
    {
        Surface(modifier = Modifier.background(Color.Blue),) {


            Card(
                colors = CardDefaults.cardColors(containerColor = Color.Blue),
                modifier = Modifier
                    .padding(5.dp),

                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 12.dp
                )
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                        contentDescription = null,
                        Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterVertically),
                    )
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = project.name, style = MaterialTheme.typography.bodyMedium)
                        Text(text = project.desc, style = MaterialTheme.typography.bodySmall)

                    }
                }
            }
        }
    }

    private fun getProjectList():List<Project> {
        return listOf(
            Project(name ="Vijay Singh", desc = "Chauhan" ),
            Project(name ="Vijay Singh", desc = "Chauhan" ),
            Project(name ="Vijay Singh", desc = "Chauhan" ),
            Project(name ="Vijay Singh", desc = "Chauhan" ),
            Project(name ="Vijay Singh", desc = "Chauhan" ),

            )
    }

    //
}
