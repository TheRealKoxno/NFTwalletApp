package com.koxno.nftwallet.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NftResponse(
    @SerialName("nfts")
    val nfts: List<NftNw>?,
    @SerialName("response")
    val response: String?,
//    @SerialName("total")
//    val total: Int?
)