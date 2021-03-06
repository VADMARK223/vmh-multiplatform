package com.vadmark223.common.view.delegate

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vadmark223.common.data.User
import com.vadmark223.common.getPainter

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
@Composable
fun User(user: User, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val vadmarkModifier = Modifier.width(50.dp).clip(RoundedCornerShape(25.dp))
            Image(
                painter = getPainter("vadmark.jpg"),//painterResource("vadmark.jpg"),
                contentDescription = "",
                modifier = vadmarkModifier,
                contentScale = ContentScale.FillWidth
            )

            Column {
                Text(
                    text = user.lastName + " " + user.firstName,
                    style = MaterialTheme.typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
                /*Text(
                    text = "${Random.nextInt(1, 10)} minutes ago",
                    style = MaterialTheme.typography.overline,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )*/
            }
        }
    }
}