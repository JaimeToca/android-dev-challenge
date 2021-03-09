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
package com.example.androiddevchallenge.ui.theme.details

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.DogUiFactory
import com.example.androiddevchallenge.model.DogUiModel
import com.example.androiddevchallenge.ui.theme.*
import com.example.androiddevchallenge.ui.theme.list.MainActivity.Companion.DOG_ID

class DogDetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id: Int = intent.getIntExtra(DOG_ID, 0)
        val dog = DogUiFactory.getDogById(id)
        setContent {
            MyTheme {
                TransparentTopAppBar(windows = window)
                MyDogDetails(dog)
            }
        }
    }

    @Composable
    fun MyDogDetails(dog: DogUiModel) {
        Surface(color = primary, modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {
                MainImage(dog)
                CardInfo(dog)
                MoreDetailsInfo(dog)
                AdoptMeButton()
            }
        }
    }

    @Composable
    fun MainImage(dog: DogUiModel) {
        Image(
            painter = painterResource(id = dog.picture),
            contentDescription = "Dog face",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )
    }

    @Composable
    fun CardInfo(dog: DogUiModel) {
        Card(
            modifier = Modifier
                .padding(32.dp)
                .offset(y = (-82).dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = 3.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = dog.name,
                        style = typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Image(
                        painterResource(id = R.drawable.ic_outline_favorite_border_24),
                        contentDescription = "favorite_details",
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
    }

    @Composable
    fun MoreDetailsInfo(dog: DogUiModel) {
        Column(
            modifier = Modifier
                .offset(y = (-90).dp)
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BoxInformation(key = "Age", value = "2")
                BoxInformation(key = "Sex", value = "Male")
                BoxInformation(key = "Color", value = "White")
                BoxInformation(key = "Lenght", value = "2-5")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ",
                style = typography.subtitle2,
                color = Color.Gray
            )
        }
    }

    @Composable
    fun BoxInformation(key: String, value: String) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = key,
                style = typography.subtitle1,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .width(70.dp)
                    .height(30.dp),
                elevation = 3.dp,
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = value, style = typography.subtitle1, color = Color.Gray)
                }
            }
        }
    }

    @Composable
    fun AdoptMeButton() {
        Button(
            onClick = { },
            modifier = Modifier
                .offset(y = (-60).dp)
                .height(52.dp)
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(text = "ADOPT ME", color = Color.Black)
        }
    }
}

