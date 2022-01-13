package com.koxno.nftwallet.presentation

import android.os.Bundle
import com.koxno.nftwallet.R
import com.koxno.nftwallet.presentation.NFTs.NFTFragment
import com.koxno.nftwallet.presentation.common.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            val fragment = NFTFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_activity_container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }

    }
}