package com.ilnytskyi.spendbase.data.remote.dto.card

import com.ilnytskyi.spendbase.domain.model.card.CardHolder

data class CardHolderDto(
    val email: String,
    val fullName: String,
    val id: String,
    val logoUrl: String
)

fun CardHolderDto.toCardHolder(): CardHolder {
    return CardHolder(email, fullName, id, logoUrl)
}
