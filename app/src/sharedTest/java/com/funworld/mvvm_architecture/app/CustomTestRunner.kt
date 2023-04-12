/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.app

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

/**
 * Set to app gradle:
 * testInstrumentationRunner = "com.neolab.mvvm_architecture.app.CustomTestRunner"
 */
class CustomTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        classLoader: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(classLoader, HiltTestApplication::class.java.name, context)
    }
}
