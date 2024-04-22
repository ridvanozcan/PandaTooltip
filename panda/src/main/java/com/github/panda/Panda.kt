package com.github.panda

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@SuppressLint("PrivateResource")
@Composable
fun Panda(
    modifier: Modifier,
    pandaState: Boolean,
    backgroundColor: Color,
    content: @Composable (Modifier) -> Unit,
    tooltipContent: @Composable () -> Unit,
    onDismissRequest: (Boolean) -> Unit,
) {
    Box(modifier = modifier) {
        PandaTooltip(
            modifier = Modifier,
            pandaState = pandaState,
            backgroundColor = backgroundColor,
            requesterView = { modifier ->
                content(modifier)
            },
            tooltipContent = {
                tooltipContent()
            },
            pandaDismissRequest = {
                onDismissRequest(it)
            }
        )
    }
}