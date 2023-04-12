/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.test.core.app.ActivityScenario
import com.funworld.mvvm_architecture.utils.liveData.SingleEvent as Event
import org.junit.Assert.assertEquals

fun assertLiveDataEventTriggered(
    liveData: LiveData<Event<String>>,
    taskId: String
) {
    val value = LiveDataTestUtil.getValue(liveData)
    assertEquals(value.getContentIfNotHandled(), taskId)
}

inline fun <reified T : Activity> launch(intent: Intent): ActivityScenario<T> =
    ActivityScenario.launch(intent)

inline fun <reified T : Activity> launchActivity(
    context: Context,
    savedState: Bundle? = null,
    moreSetup: Intent.() -> Unit = {}
): ActivityScenario<T> =
    ActivityScenario.launch(Intent(context, T::class.java).apply { moreSetup(this) }, savedState)
