/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.funworld.mvvm_architecture.data.local.sharedpfers.DefaultSharePrefsService
import com.funworld.mvvm_architecture.data.local.sharedpfers.SharePrefsService
import com.google.gson.Gson
import com.funworld.mvvm_architecture.data.local.sharedpfers.SharedPrefKeys
import com.funworld.mvvm_architecture.data.local.sharedpfers.SharedPrefsWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun providerSharedPrefs(app: Application): SharedPreferences {
        return app.getSharedPreferences(
            SharedPrefKeys.SHARED_PREFS_NAME, Context.MODE_PRIVATE
        )
    }

    @Singleton
    @Provides
    fun providerSharedPrefsWrapper(
        sharedPreferences: SharedPreferences,
        gson: Gson
    ): SharedPrefsWrapper {
        return SharedPrefsWrapper(sharedPreferences, gson)
    }

    @Singleton
    @Provides
    fun provideSharePrefService(sharedPrefsWrapperDefault: SharedPrefsWrapper): SharePrefsService {
        return DefaultSharePrefsService(sharedPrefsWrapperDefault)
    }
}
