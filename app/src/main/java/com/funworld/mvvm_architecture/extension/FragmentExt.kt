/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.extension

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

/**
 * Copyright © 2020 Neolab VN.
 * Created by ThuanPx on 8/6/20.
 */

fun Fragment.hideKeyboard() {
    val windowToken = this.activity?.currentFocus?.windowToken ?: return
    (this.context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(windowToken, 0)
}
