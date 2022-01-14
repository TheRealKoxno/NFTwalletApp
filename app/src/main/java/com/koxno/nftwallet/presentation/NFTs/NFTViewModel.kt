package com.koxno.nftwallet.presentation.NFTs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koxno.nftwallet.domain.NFTRepository
import com.koxno.nftwallet.domain.entity.ChainValues
import com.koxno.nftwallet.domain.entity.NFT
import com.koxno.nftwallet.presentation.common.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NFTViewModel @Inject constructor(
    private val nftRepository: NFTRepository
) : ViewModel() {

    private val _nftsState = MutableLiveData<List<NFT>>()
    val nftState :LiveData<List<NFT>> = _nftsState

    private val _openDetailAction = SingleLiveEvent<NFT>()
    val openDetailAction: LiveData<NFT> = _openDetailAction

    fun start(searchType: SearchType, searchNFT: String) {
        viewModelScope.launch {
            val nfts: List<NFT> = if (searchType == SearchType.OWNED)
                nftRepository.getNftOwned(searchNFT, ChainValues.ethereum, 1)
            else
                nftRepository.getNftCreated(searchNFT, ChainValues.ethereum)
            _nftsState.value = nfts
        }
    }

    fun onNFTClicked(nft: NFT) {
        _openDetailAction.value = nft
    }
}
