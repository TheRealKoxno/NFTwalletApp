package com.koxno.nftwallet.presentation.searchNFT

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.koxno.nftwallet.R
import com.koxno.nftwallet.databinding.SearchStartScreenBinding
import com.koxno.nftwallet.presentation.NFTs.NFTFragment
import com.koxno.nftwallet.presentation.common.BaseFragment
import com.koxno.nftwallet.presentation.common.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchNFTFragment : BaseFragment(R.layout.search_start_screen) {

    private val viewBinding by viewBinding(SearchStartScreenBinding::bind)
    private val viewModel by viewModels<SearchNFTViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.searchSubmit.setOnClickListener {
            search()
        }

        viewModel.searchState.observe(viewLifecycleOwner) {
            viewBinding.searchNftToLayout.error =
                if (it == SearchState.EMPTY) "Input ethereum address" else ""
        }
    }

    private fun search() {
//        var searchNFT = viewBinding.searchNftToEdit.text.toString()
//        if (searchNFT == "") {
//            searchNFT = viewBinding.searchNftToLayout.placeholderText.toString()
//        }
        var searchNFT = viewBinding.searchNftToEdit.text.toString()
        if (!viewModel.search(searchNFT))
            return

        parentFragmentManager.navigate(NFTFragment(searchNFT))
    }
}