package com.koxno.nftwallet.presentation.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.koxno.nftwallet.R.anim
import com.koxno.nftwallet.R.id

fun FragmentManager.navigate(fragment: Fragment) {
    commit(allowStateLoss = true) {
        setCustomAnimations(
            anim.slide_from_right,
            anim.slide_to_left,
            anim.slide_from_left,
            anim.slide_to_right
        )
        replace(id.main_activity_container, fragment)
        addToBackStack(null)
    }
}