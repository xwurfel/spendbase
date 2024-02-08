package com.ilnytskyi.spendbase.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ilnytskyi.spendbase.domain.model.card.Card
import com.ilnytskyi.spendbase.domain.model.card.CardHolder
import com.ilnytskyi.spendbase.ui.theme.Neutral500

@Composable
fun HomeMyCards(
    cards: List<Card>, modifier: Modifier = Modifier
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
                MyCardsItem(card = it){
                    // TODO navigate to card details
                }
            }
        }
    }
}

@Composable
private fun MyCardsItem(
    card: Card,
    modifier: Modifier = Modifier,
    onClick: (Card) -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(vertical = 8.dp)
            .clickable { onClick(card) },
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // TODO add card logo/badge
        Text(text = card.cardLast4, style = MaterialTheme.typography.bodyLarge)
        Text(
            text = card.cardName,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f),
            overflow = TextOverflow.Ellipsis
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            tint = Neutral500
        )

    }
}

@Preview
@Composable
private fun PreviewMyCardsItem() {
    MyCardsItem(
        card = Card(
            id = "1",
            cardHolder = CardHolder(
                email = "ad", fullName = "ad", logoUrl = "ad", id = "CDID"
            ),
            cardLast4 = "1234",
            cardName = "Slack",
            fundingSource = "Visa",
            isLocked = false,
            isTerminated = false,
            issuedAt = "ada",
            limit = 1000,
            limitType = "limitType",
            spent = 100,
        )
    )
}

@Preview(name = "HomeMyCards")
@Composable
private fun PreviewHomeMyCards() {
    HomeMyCards(
        listOf(
            Card(
                id = "1",
                cardHolder = CardHolder(
                    email = "ad", fullName = "ad", logoUrl = "ad", id = "CDID"
                ),
                cardLast4 = "1234",
                cardName = "Slack",
                fundingSource = "Visa",
                isLocked = false,
                isTerminated = false,
                issuedAt = "ada",
                limit = 1000,
                limitType = "limitType",
                spent = 100,
            ), Card(
                id = "1",
                cardHolder = CardHolder(
                    email = "ad", fullName = "ad", logoUrl = "ad", id = "CDID"
                ),
                cardLast4 = "1234",
                cardName = "Slack",
                fundingSource = "Visa",
                isLocked = false,
                isTerminated = false,
                issuedAt = "ada",
                limit = 1000,
                limitType = "limitType",
                spent = 100,
            ), Card(
                id = "1",
                cardHolder = CardHolder(
                    email = "ad", fullName = "ad", logoUrl = "ad", id = "CDID"
                ),
                cardLast4 = "1234",
                cardName = "Slack",
                fundingSource = "Visa",
                isLocked = false,
                isTerminated = false,
                issuedAt = "ada",
                limit = 1000,
                limitType = "limitType",
                spent = 100,
            )
        )
    )
}