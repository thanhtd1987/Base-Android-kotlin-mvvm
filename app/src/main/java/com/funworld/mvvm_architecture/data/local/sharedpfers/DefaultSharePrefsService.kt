/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.data.local.sharedpfers

class DefaultSharePrefsService(private val sharedPrefsWrapper: SharedPrefsWrapper) :
    SharePrefsService {

    override var apiToken: String
        get() = sharedPrefsWrapper[SharedPrefKeys.API_TOKEN_KEY]
        set(value) {
            sharedPrefsWrapper[SharedPrefKeys.API_TOKEN_KEY] = value
        }
}
