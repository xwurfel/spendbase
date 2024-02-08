package com.ilnytskyi.spendbase.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ilnytskyi.spendbase.R
import com.ilnytskyi.spendbase.domain.model.card.Card
import com.ilnytskyi.spendbase.domain.model.transaction.Account
import com.ilnytskyi.spendbase.domain.model.transaction.Merchant
import com.ilnytskyi.spendbase.domain.model.transaction.Transaction
import com.ilnytskyi.spendbase.ui.theme.Neutral500
import com.ilnytskyi.spendbase.ui.theme.SpendbaseTheme

@Composable
fun HomeRecentTransactions(
    transactions: List<Transaction>,
    modifier: Modifier = Modifier
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
                    text = "Recent transactions", style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "See All", style = MaterialTheme.typography.bodyMedium.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
            transactions.forEach {
                RecentTransactionItem(transaction = it)
            }

        }
    }
}

@Composable
fun RecentTransactionItem(
    transaction: Transaction, onClick: (Transaction) -> Unit = {}, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(vertical = 8.dp)
            .clickable { onClick(transaction) },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        //TODO add images of transaction and receipt
        Image(
            painter = painterResource(id = R.drawable.ic_account),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Column {
            Text(text = transaction.origin, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "•• ${transaction.account.accountLast4}",
                style = MaterialTheme.typography.bodySmall,
                color = Neutral500
            )
        }

        // TODO handle negative amounts
        Text(
            text = "$${transaction.amount}",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End,
            color = if (transaction.amount > 0)
                MaterialTheme.colorScheme.onTertiary
            else MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_home), contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

    }

}

@Preview
@Composable
private fun PreviewRecentTransactionItem() {
    SpendbaseTheme {
        RecentTransactionItem(mockTransaction)
    }
}

@Preview(name = "HomeRecentTransactions")
@Composable
private fun PreviewHomeRecentTransactions() {
    SpendbaseTheme {
        HomeRecentTransactions(listOf(mockTransaction, mockTransaction, mockTransaction))
    }
}

val mockAccount = Account(
    accountLast4 = "1234",
    accountName = "Sample Account",
    accountType = "Checking"
)

val mockMerchant = Merchant(
    icon = null,
    name = "Sample Merchant"
)

val mockTransaction = Transaction(
    account = mockAccount,
    amount = 99.99,
    attachments = emptyList(),
    card = null,
    category = null,
    completeDate = "2024-02-08",
    createDate = "2024-02-01",
    id = "trans_123456789",
    merchant = mockMerchant,
    origin = "Online Purchase",
    publicId = "pub_987654321",
    status = "Completed",
    type = "Purchase"
)
