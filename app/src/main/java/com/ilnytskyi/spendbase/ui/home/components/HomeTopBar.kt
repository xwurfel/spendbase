package com.ilnytskyi.spendbase.ui.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ilnytskyi.spendbase.R
import com.ilnytskyi.spendbase.ui.home.HomeEvent
import com.ilnytskyi.spendbase.ui.theme.SpendbaseTheme

@Composable
fun HomeTopBar(
    homeEvent: (HomeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = "Money",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Card",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bank),
                contentDescription = "Bank",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(24.dp)
            )

        }
    }
}

@Preview
@Composable
private fun PreviewHomeTopBar() {
    SpendbaseTheme {
        HomeTopBar(
            homeEvent = {},
            modifier = Modifier.size(360.dp)
        )
    }
}