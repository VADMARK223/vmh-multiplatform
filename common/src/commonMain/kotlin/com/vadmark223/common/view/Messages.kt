package com.vadmark223.common.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vadmark223.common.data.Message
import com.vadmark223.common.repository.MessagesRepo

/**
 * @author Markitanov Vadim
 * @since 17.04.2022
 */
@Composable
fun Messages(modifier: Modifier, messagesRepo: MessagesRepo) {
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
            itemsIndexed(items = messagesRepo.items()/*.reversed()*/) { index, message ->
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

        /*val firstItemVisible by remember {
            derivedStateOf {
                lazyListState.firstVisibleItemIndex == 0
            }
        }*/

        Button(
            onClick = {
//                coroutineScope.launch {
//                    lazyListState.animateScrollToItem(index = 21)
//                }
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