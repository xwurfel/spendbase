package com.ilnytskyi.spendbase.data.remote.dto.transaction

import com.ilnytskyi.spendbase.data.remote.dto.card.CardDto
import com.ilnytskyi.spendbase.data.remote.dto.card.toCard
import com.ilnytskyi.spendbase.domain.model.transaction.Transaction

data class TransactionDto(
    val account: AccountDto,
    val amount: Double,
    val attachments: List<Any?>,
    val card: CardDto?,
    val category: Any?,
    val completeDate: String,
    val createDate: String,
    val id: String,
    val merchant: MerchantDto,
    val origin: String,
    val publicId: String,
    val status: String,
    val type: String
)

fun TransactionDto.toTransaction(): Transaction {
    return Transaction(
        account.toAccount(),
        amount,
        attachments,
        card?.toCard(),
        category,
        completeDate,
        createDate,
        id,
        merchant.toMerchant(),
        origin,
        publicId,
        status,
        type
    )
}
