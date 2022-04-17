package com.vadmark223.common.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vadmark223.common.data.Message

/**
 * @author Markitanov Vadim
 * @since 17.04.2022
 */
@Composable
fun MessageBox(message: Message) {
    Column(
        modifier = Modifier
            .background(
                color = when (message.isMy) {
                    true -> Color(43, 82, 120)
                    else -> Color(24, 37, 51)
                },
                shape = RoundedCornerShape(5.dp)
            )
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Text(text = message.text, color = Color.White)
        Row(
            horizontalArrangement = Arrangement.End
        ) {
            val currentDate = "Date()"
            Text(
                text = currentDate,
                style = MaterialTheme.typography.overline,
                color = Color.Gray
            )
        }
    }
}