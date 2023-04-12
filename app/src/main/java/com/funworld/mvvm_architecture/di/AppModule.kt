/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.di

import android.app.Application
import android.content.res.Resources
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.funworld.mvvm_architecture.data.remote.api.middleware.BooleanAdapter
import com.funworld.mvvm_architecture.data.remote.api.middleware.DoubleAdapter
import com.funworld.mvvm_architecture.data.remote.api.middleware.IntegerAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Copyright © 2020 Neolab VN.
 * Created by ThuanPx on 8/5/20.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        val booleanAdapter = BooleanAdapter()
        val integerAdapter = IntegerAdapter()
        val doubleAdapter = DoubleAdapter()
        return GsonBuilder()
            .registerTypeAdapter(Boolean::class.java, booleanAdapter)
            .registerTypeAdapter(Int::class.java, integerAdapter)
            .registerTypeAdapter(Double::class.java, doubleAdapter)
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    @Singleton
    @Provides
    fun provideResources(app: Application): Resources {
        return app.resources
    }
}
