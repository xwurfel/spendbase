package com.ilnytskyi.spendbase.domain.repository.transaction

import com.ilnytskyi.spendbase.domain.model.transaction.Transaction

interface TransactionRepository {
    suspend fun getTransactions(): List<Transaction>
}