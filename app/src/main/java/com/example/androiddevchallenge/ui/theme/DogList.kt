package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.model.DogUiModel

@Composable

fun DogList(dogs: List<DogUiModel>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(dogs) { dog ->
            DogItem(dog = dog)
        }
    }
}

@Composable
fun DogItem(dog: DogUiModel) {
    Text(text = dog.name)
}