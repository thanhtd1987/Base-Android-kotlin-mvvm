/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.model.uimodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * This is sample model, u can delete this model.
 */

@Parcelize
data class Task(val name: String) : Parcelable
