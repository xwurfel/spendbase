package com.ilnytskyi.spendbase.domain.model.transaction

data class Merchant(
    val icon: Any?,
    val name: String?
)

fun Merchant.iconUrl(): String? {
    var trimmedLink: String? = null

    if (icon is String) {
        val pngIndex = icon.indexOf(".png")

        if (pngIndex != -1) {
            trimmedLink = icon.substring(0, pngIndex + 4)
        }
    }

    return trimmedLink
}