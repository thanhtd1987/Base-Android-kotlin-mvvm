/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.model.converter

import com.funworld.mvvm_architecture.data.local.entity.TaskEntity
import com.funworld.mvvm_architecture.data.remote.request.TaskRequest
import com.funworld.mvvm_architecture.data.remote.response.TaskResponse
import com.funworld.mvvm_architecture.model.uimodel.Task

object TaskConverter {

    fun convertTaskToTaskRequest(task: Task) = TaskRequest(
        taskName = task.name
    )

    fun convertTaskResponseToTask(taskResponse: TaskResponse) = Task(
        name = taskResponse.name
    )

    fun convertTaskEntityToTask(taskEntity: TaskEntity): Task = taskEntity
}
