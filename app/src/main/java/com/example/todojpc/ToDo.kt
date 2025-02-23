package com.example.todojpc

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

data class ToDo(
    val id: Int,
    val title: String,
    val createdAt: Date


)

@RequiresApi(Build.VERSION_CODES.O)
fun getFakeToDo(): List<ToDo> {

return listOf(
    ToDo(1, "Title1", Date.from(Instant.now())),
    ToDo(2, "Title2", Date.from(Instant.now())),
    ToDo(3, "Title3", Date.from(Instant.now())),
    ToDo(4, "Title4", Date.from(Instant.now())),
    ToDo(5, "Title5", Date.from(Instant.now())),
)
}

