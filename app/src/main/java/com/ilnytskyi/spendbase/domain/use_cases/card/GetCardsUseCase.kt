package com.ilnytskyi.spendbase.domain.use_cases.card

import com.ilnytskyi.spendbase.domain.model.card.Card
import com.ilnytskyi.spendbase.domain.repository.card.CardRepository
import com.ilnytskyi.spendbase.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(
    private val cardRepository: CardRepository
){
    suspend operator fun invoke() : Flow<Resource<List<Card>>> = flow {
        try {
            emit(Resource.Loading<List<Card>>())
            val cards = cardRepository.getCards()
            emit(Resource.Success<List<Card>>(cards))
        } catch (e: Exception) {
            emit(Resource.Error<List<Card>>(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}