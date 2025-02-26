package com.example.todojpc

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private var _todolist = mutableListOf<List<ToDo>>()
    var todoList: MutableList<List<ToDo>> = _todolist




}