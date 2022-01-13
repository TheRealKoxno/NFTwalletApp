package com.koxno.nftwallet.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Metadata(
    @SerialName("animation_url")
    val animationUrl: String?,
    @SerialName("background_color")
    val backgroundColor: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("external_url")
    val externalUrl: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("name")
    val name: String?
)