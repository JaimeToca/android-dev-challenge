/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.DogUiModel
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun DogList(dogs: List<DogUiModel>, modifier: Modifier = Modifier, onClick: (DogUiModel) -> Unit) {
    LazyColumn(
        modifier = modifier
    ) {
        items(dogs) { dog ->
            DogItem(dog = dog, onClick = {
               onClick(dog)
            })
        }
    }
}

@Composable
fun DogItem(dog: DogUiModel, onClick: (DogUiModel) -> Unit) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White)
            .graphicsLayer { shape = RoundedCornerShape(16.dp); shadowElevation = 1.dp.toPx() }
            .clickable { onClick(dog) }
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = dog.picture),
            contentDescription = "Dog face",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(128.dp)
                .width(120.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = dog.name,
                    style = typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Image(
                    painterResource(id = R.drawable.ic_outline_favorite_border_24),
                    contentDescription = "favorite",
                )
            }
            Text(
                text = dog.race,
                style = typography.subtitle1,
                color = Color.Black
            )
            Text(text = dog.description, style = typography.subtitle1, color = Color.Gray)
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}