package com.vadmark223.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vadmark223.common.resources.darkThemeColors
import com.vadmark223.common.view.InputMessage
import com.vadmark223.common.view.Messages
import com.vadmark223.common.view.UserInfo

@Composable
fun App() {
    MaterialTheme(colors = darkThemeColors) {
        Column(modifier = Modifier.fillMaxSize()) {
            UserInfo()
            Messages(
                Modifier
                    .weight(1f)
                    .background(color = Color(14, 22, 33))
            )
            InputMessage()
        }
    }
}
