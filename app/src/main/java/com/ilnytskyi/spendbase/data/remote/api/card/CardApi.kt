package com.ilnytskyi.spendbase.data.remote.api.card

import com.ilnytskyi.spendbase.data.remote.dto.card.CardDto
import com.ilnytskyi.spendbase.data.remote.dto.card.CardsListDto
import retrofit2.http.GET

interface CardApi {
    @GET("cards")
    suspend fun getCards(): CardsListDto
}