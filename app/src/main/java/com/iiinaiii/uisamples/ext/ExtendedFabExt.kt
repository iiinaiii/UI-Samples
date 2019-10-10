package com.iiinaiii.uisamples.ext

import androidx.databinding.BindingAdapter
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

@BindingAdapter("isExtend")
fun ExtendedFloatingActionButton.bindIsExtend(isExtend: Boolean?) {
    isExtend ?: return
    when {
        isExtend -> extend()
        else -> shrink()
    }
}