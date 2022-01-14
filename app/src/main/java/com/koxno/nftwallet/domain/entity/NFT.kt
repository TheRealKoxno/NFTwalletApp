package com.koxno.nftwallet.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NFT(
    val name: String,
    var image: String
): Parcelable