package com.koxno.nftwallet.data.network.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NftNw(
    @SerialName("cached_file_url")
    val cachedFileUrl: String?,
    @SerialName("contract_address")
    val contractAddress: String?,
    @SerialName("creator_address")
    val creatorAddress: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("file_url")
    val fileUrl: String?,
    @SerialName("metadata")
    val metadata: Metadata?,
    @SerialName("metadata_url")
    val metadataUrl: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("token_id")
    val tokenId: String?
)