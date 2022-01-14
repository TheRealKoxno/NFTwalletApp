package com.koxno.nftwallet.domain

import com.koxno.nftwallet.domain.entity.NFT
import com.koxno.nftwallet.domain.entity.ChainValues

interface NFTRepository {

    suspend fun getNftacc(account: String, chainValues: ChainValues, page_number: Int): List<NFT>
}