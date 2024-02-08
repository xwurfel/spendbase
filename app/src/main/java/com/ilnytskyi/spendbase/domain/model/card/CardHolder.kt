package com.ilnytskyi.spendbase.domain.model.card

data class CardHolder(
    val email: String,
    val fullName: String,
    val id: String,
    val logoUrl: String
)

fun CardHolder.logoUrl(): String? {
    var trimmedLink: String? = null

    val pngIndex = logoUrl.indexOf(".png")

    if (pngIndex != -1) {
        trimmedLink = logoUrl.substring(0, pngIndex + 4)
    }

    return trimmedLink
}