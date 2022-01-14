package com.koxno.nftwallet.presentation.NFTDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.koxno.nftwallet.domain.entity.NFT
import com.koxno.nftwallet.presentation.common.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel

class NFTDetailViewModel(private val nft: NFT) : ViewModel() {

    //Передаем nft во вьюху
    private val _nftState = MutableLiveData(nft)
    val nftState : LiveData<NFT> = _nftState

    private val _closeAction = SingleLiveEvent<Unit>()
    val closeAction: LiveData<Unit> = _closeAction

    fun onClosePressed() {
        _closeAction.value = Unit
    }
}
