/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.ui.home

import android.view.LayoutInflater
import com.funworld.mvvm_architecture.common.base.BaseActivity
import com.funworld.mvvm_architecture.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Copyright © 2020 Neolab VN.
 * Created by ThuanPx on 8/5/20.
 */
@AndroidEntryPoint
class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>(HomeViewModel::class) {

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(inflater)
    }

    override fun initialize() {
    }

    override fun onSubscribeObserver() {
        super.onSubscribeObserver()
    }
}
