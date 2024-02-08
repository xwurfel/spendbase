package com.ilnytskyi.spendbase.data.remote.dto.transaction

import com.ilnytskyi.spendbase.domain.model.transaction.Merchant

data class MerchantDto(
    val icon: Any,
    val name: String?
)

fun MerchantDto.toMerchant(): Merchant {
    return Merchant(icon, name)
}