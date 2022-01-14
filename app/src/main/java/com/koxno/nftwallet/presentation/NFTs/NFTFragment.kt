package com.koxno.nftwallet.presentation.NFTs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.koxno.nftwallet.R
import com.koxno.nftwallet.databinding.NftsListBinding
import com.koxno.nftwallet.domain.entity.NFT
import com.koxno.nftwallet.presentation.NFTDetail.NFTDetailFragment
import com.koxno.nftwallet.presentation.common.BaseFragment
import com.koxno.nftwallet.presentation.common.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NFTFragment : BaseFragment(R.layout.nfts_list){

    private val viewBinding by viewBinding(NftsListBinding::bind)
    private val viewModel by viewModels<NFTViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val NFTAdapter = NFTAdapter(viewModel::onNFTClicked)
        with(viewBinding.nftList) {
            adapter = NFTAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.openDetailAction.observe(viewLifecycleOwner) {
            openDetail(it)
        }
    }

    private fun openDetail(nft: NFT) {
        parentFragmentManager.navigate(NFTDetailFragment.newInstance(nft))
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
