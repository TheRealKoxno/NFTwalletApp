package com.koxno.nftwallet.data.network

import com.koxno.nftwallet.data.network.entity.NftResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NFTApi {

    @GET("/api.nftport.xyz/v0/accounts/account_address")
    suspend fun getNftacc(
        @Query("chain") chain: String,
        @Query("account_address") account: String,
        @Query("page_number") page_number: Int,
    ): NftResponse

    companion object {

        const val api_key = "a2d8fea1-8c55-4584-9d71-35be79139182"
    }
}

