package com.ilnytskyi.spendbase.data.repository

import com.ilnytskyi.spendbase.data.remote.api.transaction.TransactionApi
import com.ilnytskyi.spendbase.data.remote.dto.transaction.toTransaction
import com.ilnytskyi.spendbase.domain.model.transaction.Transaction
import com.ilnytskyi.spendbase.domain.repository.transaction.TransactionRepository
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val api: TransactionApi
) : TransactionRepository {
    override suspend fun getTransactions(): List<Transaction> {
        return api.getTransactions().transactions.map { transactionDto ->
            transactionDto.toTransaction()
        }
    }
}