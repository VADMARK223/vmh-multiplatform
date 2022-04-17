// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.vadmark223.common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AppPreview() {
//    App()
    val vadmarkModifier = Modifier.width(50.dp).clip(RoundedCornerShape(25.dp))
    Image(
        painter = painterResource("vadmark.jpg"),
        contentDescription = "Vadmark",
        modifier = vadmarkModifier,
        contentScale = ContentScale.FillWidth
    )
}