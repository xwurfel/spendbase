package com.ilnytskyi.spendbase.data.remote.dto.card

import com.ilnytskyi.spendbase.domain.model.card.Card

data class CardDto(
    val cardHolder: CardHolderDto,
    val cardLast4: String,
    val cardName: String,
    val fundingSource: String,
    val id: String,
    val isLocked: Boolean,
    val isTerminated: Boolean,
    val issuedAt: String,
    val limit: Int,
    val limitType: String,
    val spent: Int
)

fun CardDto.toCard(): Card {
    return Card(
        cardHolder.toCardHolder(),
        cardLast4,
        cardName,
        fundingSource,
        id,
        isLocked,
        isTerminated,
        issuedAt,
        limit,
        limitType,
        spent
    )
}
