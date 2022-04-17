package com.vadmark223.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import java.text.SimpleDateFormat
import java.util.*

actual fun getPlatformName(): String {
    return "Desktop"
}

@Composable
actual fun getPainter(resourcePath: String): Painter {
    return painterResource(resourcePath)
}

actual fun getCurrentDate(): String {
    val timeText = SimpleDateFormat("hh:mm:ss", Locale.getDefault())
    return timeText.format(Date())
}