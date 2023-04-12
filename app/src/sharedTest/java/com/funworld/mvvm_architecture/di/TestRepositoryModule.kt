/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.di

import com.funworld.mvvm_architecture.repository.task.DefaultTaskRepository
import com.funworld.mvvm_architecture.repository.task.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
object TestRepositoryModule {

    @Provides
    @Singleton
    fun provideFakeTaskRepository(): TaskRepository {
        return DefaultTaskRepository()
    }
}
