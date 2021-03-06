package com.vadmark223.common.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vadmark223.common.repository.MessagesRepo
import com.vadmark223.common.view.delegate.MessageBox
import kotlinx.coroutines.launch

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
            reverseLayout = true
        ) {
            itemsIndexed(items = messagesRepo.messageList().reversed()) { index, message ->
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

        val firstItemVisible = remember {
            derivedStateOf {
                lazyListState.firstVisibleItemIndex == 0
            }
        }

        if (!firstItemVisible.value) {
            Box(Modifier.fillMaxSize().padding(12.dp), Alignment.BottomEnd) {
                FloatingActionButton(onClick = {
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(index = 0)
                    }
                }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                }
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