package com.example.todojpc

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private var _todolist = MutableLiveData<List<ToDo>>()
    var todoList: MutableLiveData<List<ToDo>> = _todolist

    private fun getAllTodo() {
        _todolist.value = DataManager.getAllTodo().reversed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String) {
        DataManager.addTodo(title)
        getAllTodo()
    }

    fun deleteTodo(id: Int) {
        DataManager.deleteTodo(id)
        getAllTodo()
    }


}