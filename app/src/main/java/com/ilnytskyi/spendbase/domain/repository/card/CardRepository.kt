package com.ilnytskyi.spendbase.domain.repository.card

import com.ilnytskyi.spendbase.domain.model.card.Card

interface CardRepository {
    suspend fun getCards(): List<Card>
}