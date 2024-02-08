package com.ilnytskyi.spendbase.data.remote.api.transaction

import com.ilnytskyi.spendbase.data.remote.dto.transaction.TransactionsListDto
import retrofit2.http.GET

interface TransactionApi {
    @GET("cards/transactions")
    suspend fun getTransactions(): TransactionsListDto
}