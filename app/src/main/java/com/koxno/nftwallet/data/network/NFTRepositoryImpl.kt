package com.koxno.nftwallet.data.network

import com.koxno.nftwallet.domain.NFTRepository
import com.koxno.nftwallet.domain.entity.NFT
import com.koxno.nftwallet.domain.entity.ChainValues

class NFTRepositoryImpl(
    private val nftApi: NFTApi
) : NFTRepository {
    override suspend fun getNftacc(chainValues: ChainValues, page_number: Int): List<NFT> {
        return nftApi.getNftacc(chain = chainValues.serverChains, page_number)
            .nfts?.mapNotNull { Metadata ->
                NFT(
                    name = Metadata.metadata?.name ?: return@mapNotNull null,
                    image = Metadata.metadata?.image ?: return@mapNotNull null,
                )
            } ?: emptyList()
    }
}