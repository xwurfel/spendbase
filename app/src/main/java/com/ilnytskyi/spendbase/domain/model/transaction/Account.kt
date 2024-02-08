package com.ilnytskyi.spendbase.domain.model.transaction

data class Account(
    val accountLast4: String,
    val accountName: String,
    val accountType: String
)