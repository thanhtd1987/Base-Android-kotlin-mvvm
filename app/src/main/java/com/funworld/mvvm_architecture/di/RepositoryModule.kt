/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.di

import com.funworld.mvvm_architecture.repository.task.DefaultTaskRepository
import com.funworld.mvvm_architecture.repository.task.TaskRepository
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
object RepositoryModule {

    @Provides
    @Singleton
    fun providerTaskRepository(): TaskRepository {
        return DefaultTaskRepository()
    }
}
