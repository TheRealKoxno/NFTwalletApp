package com.koxno.nftwallet.presentation.common

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.koxno.nftwallet.R

fun ImageView.setImageUrl(url: String) {
    val drawable = CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_baseline_image_24)
        .placeholder(drawable)
        .into(this)
}