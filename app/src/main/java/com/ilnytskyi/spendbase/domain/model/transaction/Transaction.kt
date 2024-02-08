package com.ilnytskyi.spendbase.domain.model.transaction

import com.ilnytskyi.spendbase.domain.model.card.Card

data class Transaction(
    val account: Account,
    val amount: Double,
    val attachments: List<Any?>,
    val card: Card?,
    val category: Any?,
    val completeDate: String,
    val createDate: String,
    val id: String,
    val merchant: Merchant,
    val origin: String,
    val publicId: String,
    val status: String,
    val type: String
)