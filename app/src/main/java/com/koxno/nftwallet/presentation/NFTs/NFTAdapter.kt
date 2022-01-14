package com.koxno.nftwallet.presentation.NFTs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.koxno.nftwallet.databinding.ItemNftBinding
import com.koxno.nftwallet.domain.entity.NFT
import com.koxno.nftwallet.presentation.common.setImageUrl

class NFTAdapter(
    private val onNFTClicked: (NFT) -> Unit
) : ListAdapter<NFT, NFTAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<NFT>() {
        override fun areItemsTheSame(oldItem: NFT, newItem: NFT): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: NFT, newItem: NFT): Boolean = oldItem == newItem

    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemNftBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val item = getItem(position)
            if (item.image.isBlank())
                item.image = "https://i.ibb.co/K2kX7XQ/photo-2020-06-07-19-06-50.jpg"
            itemNftImage.setImageUrl(item.image)
            root.setOnClickListener { onNFTClicked(item) }
        }
    }

    class ViewHolder(val binding: ItemNftBinding) : RecyclerView.ViewHolder(binding.root)
}
