package com.vadmark223.common.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vadmark223.common.data.Message
import com.vadmark223.common.repository.MessagesRepo
import com.vadmark223.common.repository.MessagesRepoImpl
import kotlinx.coroutines.launch

/**
 * @author Markitanov Vadim
 * @since 17.04.2022
 */
@Composable
fun Messages(modifier: Modifier) {
    val messagesRepo: MessagesRepo = MessagesRepoImpl()

    Box(modifier = modifier) {
        val lazyListState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            state = lazyListState,
            reverseLayout = false
        ) {
            itemsIndexed(messagesRepo.items()/*.reversed()*/) { index, message ->
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = when (message.isMy) {
                        true -> Arrangement.End
                        else -> Arrangement.Start
                    }
                ) {
                    item {
                        MessageBox(message)
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }

        Button(
            onClick = {
                println("New message")
//                messagesRepo.addItem(Message(51, "New message!"))
                coroutineScope.launch {
                    lazyListState.animateScrollToItem(index = 10)
                }
            }
        ) {
            Text("Click")
        }
        /*VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
            adapter = rememberScrollbarAdapter(
                scrollState = state
            ),
            reverseLayout = true
        )*/
    }
}