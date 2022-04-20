package com.vadmark223.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vadmark223.common.repository.MessagesRepo
import com.vadmark223.common.repository.MessagesRepoImpl
import com.vadmark223.common.resources.darkThemeColors
import com.vadmark223.common.view.InputMessage
import com.vadmark223.common.view.Messages
import com.vadmark223.common.view.UserInfo
import com.vadmark223.common.view.UserItem

@Composable
fun App() {
    MaterialTheme(colors = darkThemeColors) {
        val messagesRepo: MessagesRepo = MessagesRepoImpl()

        Row {
            Column(modifier = Modifier.weight(1.0f).background(Color(14, 22, 33)).fillMaxHeight()) {
                UserItem("Головнев Андрей")
                UserItem("Ималетдинов Роман")
                UserItem("Доронин Герман")
                UserItem("Трищакин Михаил")
            }
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(2.0f)
            ) {
                UserInfo()
                Messages(
                    Modifier
                        .weight(1f)
                        .background(color = Color(14, 22, 33)),
                    messagesRepo
                )
                InputMessage(messagesRepo)
            }
        }

    }
}
