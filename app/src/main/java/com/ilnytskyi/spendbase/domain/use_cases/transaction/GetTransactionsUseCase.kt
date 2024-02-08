package com.ilnytskyi.spendbase.domain.use_cases.transaction

import com.ilnytskyi.spendbase.domain.model.transaction.Transaction
import com.ilnytskyi.spendbase.domain.repository.transaction.TransactionRepository
import com.ilnytskyi.spendbase.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
){
    suspend operator fun invoke() : Flow<Resource<List<Transaction>>> = flow {
        try {
            emit(Resource.Loading<List<Transaction>>())
            val transactions = transactionRepository.getTransactions()
            emit(Resource.Success<List<Transaction>>(transactions))
        } catch (e: Exception) {
            emit(Resource.Error<List<Transaction>>(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
 }