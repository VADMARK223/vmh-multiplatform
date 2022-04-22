package com.vadmark223.common.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vadmark223.common.repository.UsersRepo
import com.vadmark223.common.view.delegate.User

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
@Composable
fun Users(repo: UsersRepo, modifier: Modifier, onUserClick: (Int) -> Unit) {
    val usersLazyListState = rememberLazyListState()
    val selectedUserId = remember { mutableStateOf(-1) }
    LazyColumn(
        state = usersLazyListState,
        modifier = modifier
    ) {
        items(items = repo.items()) { user ->
            User(
                user = user, modifier = Modifier
                    .background(if (selectedUserId.value == user.id) Color(43, 82, 120) else Color(23, 33, 43))
                    .fillMaxWidth()
                    .selectable(user.id == selectedUserId.value,
                        onClick = {
                            if (selectedUserId.value != user.id) {
                                selectedUserId.value = user.id
                            }

                            onUserClick(user.id)
                        })
            )
        }
    }
}