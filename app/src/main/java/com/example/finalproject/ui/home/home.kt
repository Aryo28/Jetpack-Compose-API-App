package com.example.finalproject.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.userApi.user.data.api.model.User


@Composable
fun HomeScreen() {
    var showData by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Unit III Final Project",
                fontSize = 24.sp,
                style = TextStyle(fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.White
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Armando Ramos Wong",
                fontSize = 18.sp,
                style = TextStyle(fontFamily = FontFamily.Serif),
                color = Color.White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "API Get Method Functionality",
                fontSize = 18.sp,
                style = TextStyle(fontFamily = FontFamily.Serif),
                color = Color.White
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {


        }
        Row() {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), onClick = { showData = !showData }) {
                if (!showData) {
                    Text(text = "Get Users")
                } else {
                    Text(text = "Hide Users")
                }

            }
        }
        Row {
            if (showData) {
                CreateList()
            }
        }
    }

}

@Composable
fun CreateList() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()
    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }

        items(state) { user: User ->
            userCard(user = user)
        }
    }
}


@Composable
fun userCard(user: User) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Box {
            androidx.compose.material.Surface(
                color = MaterialTheme.colors.onSurface.copy(alpha = .8f),
                modifier = Modifier.align(Alignment.Center),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(text = "Username: ${user.username}")
                    Text(text = "Hashed Pass: ${user.password}")
                }
            }
        }
    }
}


