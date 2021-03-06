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
import com.koxno.nftwallet.presentation.common.setImageUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
            viewBinding.textNFTName.text = nft.name
            viewBinding.textNFTDetail.text = nft.description
            if (nft.image.endsWith(".svg")) {
                // TODO: svg load
                viewBinding.imageNFTDetail.setImageUrl("https://i.ibb.co/K2kX7XQ/photo-2020-06-07-19-06-50.jpg")
            }
            viewBinding.imageNFTDetail.setImageUrl(nft.image)
        }
        viewModel.closeAction.observe(viewLifecycleOwner) {
            closeScreen()
        }
        viewBinding.closeNftDetail.setOnClickListener {
            viewModel.onClosePressed()
        }
    }

    private fun closeScreen() {
        parentFragmentManager.popBackStack()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
