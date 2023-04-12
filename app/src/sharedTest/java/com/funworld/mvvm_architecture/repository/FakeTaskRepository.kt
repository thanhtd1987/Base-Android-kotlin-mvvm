/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.repository

import com.funworld.mvvm_architecture.data.remote.response.TaskResponse
import com.funworld.mvvm_architecture.repository.task.TaskRepository

class FakeTaskRepository(var shouldReturnError: Boolean = false) : TaskRepository {

    private val photosServiceData: LinkedHashMap<String, TaskResponse> = LinkedHashMap()
}
