package com.ilnytskyi.spendbase.ui.home.card_details_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ilnytskyi.spendbase.domain.model.card.Card
import com.ilnytskyi.spendbase.domain.model.card.logoUrl
import com.ilnytskyi.spendbase.ui.home.home_screen.components.mockCard
import com.ilnytskyi.spendbase.ui.theme.Neutral500

@Composable
fun CardDetailsTopAppBar(
    card: Card, onBackClick: () -> Unit, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back to cards list"
            )
        }
        Spacer(Modifier.weight(1f, true))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = card.cardHolder.logoUrl(),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = card.cardName, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "•• ${card.cardLast4}",
                style = MaterialTheme.typography.bodySmall,
                color = Neutral500
            )
        }
        Spacer(Modifier.weight(1f, true))
    }
}

@Preview(name = "CardDetailsTopAppBar")
@Composable
private fun PreviewCardDetailsTopAppBar() {
    CardDetailsTopAppBar(mockCard, onBackClick = {})
}