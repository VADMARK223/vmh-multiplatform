package com.vadmark223.common.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vadmark223.common.data.Message
import kotlin.random.Random

/**
 * @author Markitanov Vadim
 * @since 17.04.2022
 */
@Composable
fun Messages(modifier: Modifier) {
    val messagesList: ArrayList<Message> = arrayListOf()
    for (x in 1..50) {
        messagesList.add(Message(x, "Message $x", Random.nextBoolean()))
    }

    Box(modifier = modifier) {
        val state = rememberLazyListState()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            state = state,
            reverseLayout = true
        ) {
            items(messagesList) { message ->
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
        /*VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
            adapter = rememberScrollbarAdapter(
                scrollState = state
            ),
            reverseLayout = true
        )*/
    }
}