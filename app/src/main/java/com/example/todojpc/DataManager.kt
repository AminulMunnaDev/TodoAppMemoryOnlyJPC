package com.example.todojpc

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

object DataManager {
    private val todolist = mutableListOf<ToDo>()
    fun getAllTodo(): List<ToDo> {
        return todolist
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String) {
        todolist.add(ToDo(System.currentTimeMillis().toInt(), title, Date.from(Instant.now())))
    }

    fun deleteTodo(id: Int) {

        todolist.removeIf {
            it.id == id

        }
    }
}