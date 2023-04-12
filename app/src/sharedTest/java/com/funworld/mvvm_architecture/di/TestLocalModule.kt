/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.di

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.funworld.mvvm_architecture.data.local.sharedpfers.SharedPrefsWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

private const val TEST_SHARED_PREFERENCE_FILE_NAME = "TestSharedPreference"

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [LocalModule::class]
)
object TestLocalModule {

    @Singleton
    @Provides
    fun provideTestSharedPrefs(@ApplicationContext context: Context): SharedPreferences {
        // Make new test scope preference file to avoid change in original preference file.
        return context.getSharedPreferences(
            TEST_SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE
        )
    }

    @Singleton
    @Provides
    fun provideTestSharedPrefsWrapper(
        sharedPreferences: SharedPreferences,
        gson: Gson
    ): SharedPrefsWrapper {
        return SharedPrefsWrapper(sharedPreferences, gson)
    }
}
