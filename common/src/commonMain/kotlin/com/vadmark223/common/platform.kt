package com.vadmark223.common

import androidx.compose.ui.graphics.painter.Painter

expect fun getPlatformName(): String
expect fun getPainter(resourcePath: String): Painter