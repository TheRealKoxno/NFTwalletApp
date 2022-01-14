package com.koxno.nftwallet.presentation.searchNFT

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koxno.nftwallet.domain.NFTRepository
import com.koxno.nftwallet.presentation.common.launchWithErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchNFTViewModel @Inject constructor(
    private val nftRepository: NFTRepository
) : ViewModel () {

    private val _searchState = MutableLiveData(SearchState.VALID)
    val searchState: LiveData<SearchState> = _searchState

    fun search(searchNFT: String) : Boolean {
        if (searchNFT.isBlank()) {
            _searchState.value = SearchState.EMPTY
            return false
        }

        _searchState.value = SearchState.VALID
        return true
    }
}

enum class SearchState {
    EMPTY, VALID
}