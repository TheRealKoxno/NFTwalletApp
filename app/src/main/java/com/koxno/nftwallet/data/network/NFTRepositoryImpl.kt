package com.koxno.nftwallet.data.network

import com.koxno.nftwallet.domain.NFTRepository
import com.koxno.nftwallet.domain.entity.NFT
import com.koxno.nftwallet.domain.entity.ChainValues

class NFTRepositoryImpl(
    private val nftApi: NFTApi
) : NFTRepository {

    override suspend fun getNftOwned(account: String, chainValues: ChainValues, page_number: Int): List<NFT> {
        return nftApi.getNftOwned(account, chainValues.serverChains, page_number)
            .nfts?.mapNotNull { NftNw ->
                NFT(
                    name = NftNw.name ?: return@mapNotNull null,
                    description = NftNw.description ?: return@mapNotNull null,
                    image = NftNw.fileUrl ?: return@mapNotNull null,
                )
            } ?: emptyList()
    }

    override suspend fun getNftCreated(account: String, chainValues: ChainValues): List<NFT> {
        return nftApi.getNftCreated(account, chainValues.serverChains)
            .nfts?.mapNotNull { NftNw ->
                NFT(
                    name = NftNw.name ?: return@mapNotNull null,
                    description = NftNw.description ?: return@mapNotNull null,
                    image = NftNw.fileUrl ?: return@mapNotNull null,
                )
            } ?: emptyList()
    }
}