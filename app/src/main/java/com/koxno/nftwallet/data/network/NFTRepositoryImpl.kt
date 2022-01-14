package com.koxno.nftwallet.data.network

import com.koxno.nftwallet.domain.NFTRepository
import com.koxno.nftwallet.domain.entity.NFT
import com.koxno.nftwallet.domain.entity.ChainValues

class NFTRepositoryImpl(
    private val nftApi: NFTApi
) : NFTRepository {
    override suspend fun getNftacc(account: String, chainValues: ChainValues, page_number: Int): List<NFT> {
        return nftApi.getNftacc(account, chainValues.serverChains, page_number)
            .nfts?.mapNotNull { NftNw ->
                NFT(
                    name = NftNw.name ?: return@mapNotNull null,
                    image = NftNw.fileUrl ?: return@mapNotNull null,
                )
            } ?: emptyList()
    }

}