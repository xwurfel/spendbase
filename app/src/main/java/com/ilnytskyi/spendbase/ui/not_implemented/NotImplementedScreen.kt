package com.ilnytskyi.spendbase.ui.not_implemented

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NotImplementedScreen(
    modifier: Modifier = Modifier
) {
    Box (
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "This screen is not implemented yet")
    }
}

@Preview
@Composable
private fun PreviewNotImplementedScreen() {
    NotImplementedScreen()
}