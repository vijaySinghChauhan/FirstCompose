package com.example.firstcompose.ui.theme

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun StateManagement() {
    var username=""
    val state = remember{ mutableStateOf("")}

    TextField(value = state.value, onValueChange = {
        state.value=it
    })
}