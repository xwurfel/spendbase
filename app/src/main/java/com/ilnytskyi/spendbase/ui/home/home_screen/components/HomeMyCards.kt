package com.ilnytskyi.spendbase.ui.home.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ilnytskyi.spendbase.domain.model.card.Card
import com.ilnytskyi.spendbase.domain.model.card.CardHolder
import com.ilnytskyi.spendbase.domain.model.card.logoUrl
import com.ilnytskyi.spendbase.ui.theme.Neutral500

@Composable
fun HomeMyCards(
    cards: List<Card>, modifier: Modifier = Modifier, onClick: (String) -> Unit = {}
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row {
                Text(
                    text = "My cards", style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "See All", style = MaterialTheme.typography.bodyMedium.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
            cards.forEach {
                MyCardsItem(card = it) { card ->
                    onClick(card.id)
                }
            }
        }
    }
}

@Composable
private fun MyCardsItem(
    card: Card, modifier: Modifier = Modifier, onClick: (Card) -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(vertical = 12.dp)
            .clickable { onClick(card) },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(

        ) {
            AsyncImage(
                model = card.cardHolder.logoUrl(),
                contentDescription = null,
                Modifier
                    .width(28.dp)
                    .height(28.dp)
                    .align(Alignment.TopStart)
            )
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 24.dp,
                        spotColor = Color(0x1421222E),
                        ambientColor = Color(0x1421222E)
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0x33FFFFFF),
                        shape = RoundedCornerShape(size = 4.dp)
                    )
                    .width(48.dp)
                    .height(32.dp)
                    .background(color = Color(0xFF2B2C39), shape = RoundedCornerShape(size = 4.dp))
                    .align(Alignment.BottomEnd), contentAlignment = Alignment.BottomEnd
            ) {

                Text(
                    text = card.cardLast4,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
        Text(
            text = card.cardName,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f),
            overflow = TextOverflow.Ellipsis
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = Neutral500
        )

    }
}

@Preview
@Composable
private fun PreviewMyCardsItem() {
    MyCardsItem(
        card = mockCard
    )
}

@Preview(name = "HomeMyCards")
@Composable
private fun PreviewHomeMyCards() {
    HomeMyCards(
        listOf(mockCard, mockCard, mockCard)
    )
}

val mockCardHolder = CardHolder(
    email = "example@example.com",
    fullName = "John Doe",
    id = "holder_123",
    logoUrl = "https://example.com/logo.png"
)

val mockCard = Card(
    cardHolder = mockCardHolder,
    cardLast4 = "6789",
    cardName = "Sample Card",
    fundingSource = "Bank Account",
    id = "card_456789",
    isLocked = false,
    isTerminated = false,
    issuedAt = "2023-01-01",
    limit = 5000,
    limitType = "Monthly",
    spent = 1500
)