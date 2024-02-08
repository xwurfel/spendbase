package com.ilnytskyi.spendbase.data.remote.dto.transaction

import com.ilnytskyi.spendbase.domain.model.transaction.Account

data class AccountDto(
    val accountLast4: String,
    val accountName: String,
    val accountType: String
)

fun AccountDto.toAccount(): Account {
    return Account(accountLast4, accountName, accountType)
}