package com.koxno.nftwallet.presentation.searchNFT

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchNFTViewModel @Inject constructor() : ViewModel () {

    private val _searchState = MutableLiveData(SearchState.VALID)
    val searchState: LiveData<SearchState> = _searchState


    fun search(searchNFT: String) {
        var hasError = false
        if (searchNFT.isBlank()) {
            _searchState.value = SearchState.EMPTY
            hasError = true
        }

        if (hasError) return

        _searchState.value = SearchState.VALID
    }
}

enum class SearchState {
    EMPTY, VALID
}