package com.example.mvvm2.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvm2.R
import com.example.mvvm2.model.User

@Composable
fun allUser(
    listUser: List<User>,
    onItemClicked: (User) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // Identitas mahasiswa
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 50.dp,
                    end = 16.dp,
                    bottom = 10.dp
                )
        ) {
            Text(
                text = "NIM : 245150407111060",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Nama : Rafi Aditya Putra Ariyadi",
                style = MaterialTheme.typography.titleMedium
            )
        }

        // LazyColumn
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(10.dp)
        ) {

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Daftar Pengguna",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }

            items(
                listUser,
                key = { it.id }
            ) { user ->

                val imageRes = when (user.id) {
                    1 -> R.drawable.aku
                    2 -> R.drawable.dia
//                    3 -> R.drawable.user3
//                    4 -> R.drawable.user4
//                    5 -> R.drawable.user5
                    else -> R.drawable.aku
                }

                userCard(
                    user = user,
                    imageRes = imageRes,
                    onClick = onItemClicked
                )
            }
        }
    }
}