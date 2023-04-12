/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.extension

/**
 * Created by ThuanPx on 3/15/20.
 */

fun Boolean?.isTrue() = this == true

fun Boolean?.isNotTrue() = !this.isTrue()
