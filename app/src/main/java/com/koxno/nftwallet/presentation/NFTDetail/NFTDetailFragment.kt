package com.koxno.nftwallet.presentation.NFTDetail

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.koxno.nftwallet.R
import com.koxno.nftwallet.databinding.NftDetailBinding
import com.koxno.nftwallet.domain.entity.NFT
import com.koxno.nftwallet.presentation.common.BaseFragment

class NFTDetailFragment : BaseFragment(R.layout.nft_detail){

    companion object {
        fun newInstance(nft: NFT) = NFTDetailFragment().apply {
            arguments = bundleOf(NFT_DETAIL_DATA_KEY to nft)
        }

        private const val NFT_DETAIL_DATA_KEY = "NFT_DETAIL_DATA_KEY"
    }

    private val viewBinding by viewBinding(NftDetailBinding::bind)
    private val viewModel by viewModels<NFTDetailViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                NFTDetailViewModel(arguments?.getParcelable<NFT>(NFT_DETAIL_DATA_KEY)!!) as T
            }
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //lifecylceOwner при observe
        viewModel.nftState.observe(viewLifecycleOwner) { nft ->
            viewBinding.textNFTDetail.text = nft.name.toString()
            //viewBinding.imageNFTDetail.image = nft.image.toString()
        }

    }

}

