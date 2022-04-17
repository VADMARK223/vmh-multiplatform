package com.vadmark223.common.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.vadmark223.common.getPainter
import com.vadmark223.common.getPlatformName

/**
 * @author Markitanov Vadim
 * @since 17.04.2022
 */
@Composable
fun UserInfo() {
    val platformName = getPlatformName()

    Box(
        modifier = Modifier
            .background(Color(23, 33, 43)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color(23, 33, 43)),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val vadmarkModifier = Modifier.width(50.dp).clip(RoundedCornerShape(25.dp))
            Image(
                painter = getPainter("vadmark.jpg"),//painterResource("vadmark.jpg"),
                contentDescription = "Vadmark",
                modifier = vadmarkModifier,
                contentScale = ContentScale.FillWidth
            )

            Column {
                Text(
                    text = "Markitanov Vadim ($platformName)",
                    style = MaterialTheme.typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
                Text(
                    text = "3 minutes ago",
                    style = MaterialTheme.typography.overline,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )
            }
        }
    }

}