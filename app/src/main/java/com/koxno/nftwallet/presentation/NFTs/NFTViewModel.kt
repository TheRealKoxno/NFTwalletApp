package com.koxno.nftwallet.presentation.NFTs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koxno.nftwallet.domain.NFTRepository
import com.koxno.nftwallet.domain.entity.ChainValues
import com.koxno.nftwallet.domain.entity.NFT
import kotlinx.coroutines.launch

class NFTViewModel(
    private val nftRepository: NFTRepository
) : ViewModel() {

    private val _countState = MutableLiveData(0)
    val countState: LiveData<Int> = _countState

    private val _nftsState = MutableLiveData<List<NFT>>()
    val nftState :LiveData<List<NFT>> = _nftsState

    init {
        viewModelScope.launch {
            val nfts: List<NFT> = nftRepository.getNftacc(ChainValues.ethereum, 1)
            _nftsState.value = nfts
        }
    }

    fun onAdd() {
        _countState.value = _countState.value!! + 1
    }
}