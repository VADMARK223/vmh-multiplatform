package com.vadmark223.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vadmark223.common.repository.MessagesRepo
import com.vadmark223.common.repository.MessagesRepoImpl
import com.vadmark223.common.repository.UsersRepo
import com.vadmark223.common.resources.darkThemeColors
import com.vadmark223.common.view.InputMessage
import com.vadmark223.common.view.Messages
import com.vadmark223.common.view.UserInfo
import com.vadmark223.common.view.Users

@Composable
fun App(usersRepo: UsersRepo) {
    MaterialTheme(colors = darkThemeColors) {
        val selectedUser = remember { mutableStateOf(usersRepo.getFirst()) }
        val messagesRepo: MessagesRepo = MessagesRepoImpl(usersRepo)

        Row {
            Users(
                selectedUser,
                repo = usersRepo,
                modifier = Modifier
                    .weight(1.0f)
                    .background(Color(14, 22, 33))
                    .fillMaxHeight(),
                onUserClick = { user ->
                    messagesRepo.updateMessagesByUserId(user.id)
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2.0f)
            ) {
                UserInfo(selectedUser)
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
