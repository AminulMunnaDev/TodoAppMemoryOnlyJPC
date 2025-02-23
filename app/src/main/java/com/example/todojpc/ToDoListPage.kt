package com.example.todojpc

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListPage(modifier: Modifier = Modifier) {
    val todoList = getFakeToDo()
    var inputText by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Text(
            text = "Todo List",
            fontSize = 46.sp,
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = {
                    inputText = it
                })
            Button(
                onClick = { },
            ) {
                Text(text = "Add")
            }
        }

        LazyColumn(
            content = {
                itemsIndexed(todoList) { index: Int, item: ToDo ->
                    TodoItem(item)
                }

            })
    }
}

@SuppressLint("SimpleDateFormat")
@Composable
fun TodoItem(item: ToDo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Column(modifier = Modifier.weight(1f))
        {
            Text(
                text = SimpleDateFormat("HH:mm:aa dd/MM/yyyy", Locale.ENGLISH)
                    .format(item.createdAt),
                style = MaterialTheme.typography.bodySmall,
                fontSize = 12.sp,
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = item.title,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        IconButton(
            onClick = { },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.delete_icon),
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}
