/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.utils

import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class KeyboardDetector(
    activity: AppCompatActivity,
    private val rootLayout: View,
    private val onChangedListener: (show: Boolean) -> Unit
) {
    private var keyboardListenersAttached = false
    private var originalHeight = 0
    private var isOpen = false

    private val keyboardLayoutListener = OnGlobalLayoutListener {
        val heightDiff = originalHeight - rootLayout.height
        val isOpen = heightDiff > 0
        if (this.isOpen == isOpen) return@OnGlobalLayoutListener
        this.isOpen = isOpen
        onChangedListener(isOpen)
    }

    init {
        activity.lifecycle.addObserver(ActivityObserver())
    }

    private inner class ActivityObserver : DefaultLifecycleObserver {

        override fun onCreate(owner: LifecycleOwner) {
            rootLayout.post {
                if (keyboardListenersAttached) {
                    return@post
                }
                originalHeight = rootLayout.height
                rootLayout.viewTreeObserver.addOnGlobalLayoutListener(keyboardLayoutListener)
                keyboardListenersAttached = true
            }
        }

        override fun onDestroy(owner: LifecycleOwner) {
            if (keyboardListenersAttached)
                rootLayout.viewTreeObserver.removeOnGlobalLayoutListener(keyboardLayoutListener)
            keyboardListenersAttached = false
        }
    }

    fun isOpen() = isOpen
}
