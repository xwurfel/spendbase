package com.ilnytskyi.spendbase.data.repository

import com.ilnytskyi.spendbase.data.remote.api.card.CardApi
import com.ilnytskyi.spendbase.data.remote.dto.card.toCard
import com.ilnytskyi.spendbase.domain.model.card.Card
import com.ilnytskyi.spendbase.domain.repository.card.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val api: CardApi
): CardRepository {
    override suspend fun getCards(): List<Card> {
        return api.getCards().cards.map {
            it.toCard()
        }
    }
}