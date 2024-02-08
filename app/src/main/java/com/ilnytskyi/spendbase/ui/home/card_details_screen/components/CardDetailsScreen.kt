package com.ilnytskyi.spendbase.ui.home.card_details_screen.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ilnytskyi.spendbase.R
import com.ilnytskyi.spendbase.domain.model.card.Card
import com.ilnytskyi.spendbase.domain.model.transaction.Transaction
import com.ilnytskyi.spendbase.ui.theme.Neutral500
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CardDetailsScreen(
    card: Card,
    transactions: List<Transaction>,
    paddingValues: PaddingValues,
    onBackPressed: () -> Unit
) {
    val groupedTransactions = remember {
        transactions.groupBy { transaction ->
            LocalDate.parse(
                transaction.completeDate.substringBefore("T"), DateTimeFormatter.ISO_DATE
            )
        }
    }

    val categories = remember {
        groupedTransactions.map { (date, transactions) ->
            val formattedDate = date.format(
                DateTimeFormatter.ofPattern("MMM dd").withLocale(Locale.ENGLISH)
            )
            Category(formattedDate, transactions)
        }.sortedByDescending { it.date }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                CardDetailsTopAppBar(card = card, onBackClick = { onBackPressed() })
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.img_spendbase_card),
                    contentDescription = null,
                    modifier = Modifier.aspectRatio(256f / 82f)
                )

                Surface(
                    shadowElevation = 8.dp,
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_card_details_action_bar),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .aspectRatio(256f / 72f, true),
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp),
                color = MaterialTheme.colorScheme.background,
                shadowElevation = 2.dp
            ) {
                LazyColumn {
                    item {
                        Text(
                            text = "Activity",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 40.dp),
                            textAlign = TextAlign.Center
                        )
                    }

                    categories.forEach { category ->
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                            CategoryHeader(category.date, modifier = Modifier.padding(horizontal = 16.dp))
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        category.items.forEach { transaction ->
                            item {
                                CategoryItem(transaction, modifier = Modifier.padding(horizontal = 16.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

private data class Category(
    val date: String, val items: List<Transaction>
)

@Composable
private fun CategoryHeader(
    text: String, modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = Neutral500,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    )
    Divider(color = Neutral500, thickness = 1.dp, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryItem(
    transaction: Transaction, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BadgedBox(modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface), badge = {
            if (transaction.status != "Success") Badge(containerColor = MaterialTheme.colorScheme.errorContainer)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_my_cards),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
        }

        Text(
            text = transaction.origin,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        )

        Text(
            text = if (transaction.amount >= 0) "$${transaction.amount}"
            else "-$${-transaction.amount}",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End,
            color = if (transaction.amount > 0) MaterialTheme.colorScheme.onTertiary
            else MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_receipt_added),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}
