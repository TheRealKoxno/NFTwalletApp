package com.koxno.nftwallet.presentation.NFTDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.koxno.nftwallet.domain.entity.NFT

class NFTDetailViewModel(private val nft: NFT) : ViewModel() {

    //Передаем nft во вьюху
    private val _nftState = MutableLiveData(nft)
    val nftState : LiveData<NFT> = _nftState

}

