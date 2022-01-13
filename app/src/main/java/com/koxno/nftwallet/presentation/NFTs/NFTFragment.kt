package com.koxno.nftwallet.presentation.NFTs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.koxno.nftwallet.R
import com.koxno.nftwallet.databinding.NftsListBinding
import com.koxno.nftwallet.presentation.common.BaseFragment

class NFTFragment : BaseFragment(R.layout.nfts_list){

    private val viewBinding by viewBinding(NftsListBinding::bind)
    private val viewModel by viewModels<NFTViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.nftDetails.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}