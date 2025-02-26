package com.example.todojpc

object DataManager {
    private val todolist = mutableListOf<ToDo>()
    fun getAllTodo(): List<ToDo> {
       return todolist
    }

    fun adTodo(title: String)  {

    }

    fun deleteTodo(id:Int) {

    }
}