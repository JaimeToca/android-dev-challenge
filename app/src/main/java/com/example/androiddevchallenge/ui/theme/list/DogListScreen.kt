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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.details.DogDetailsScreen
import com.example.androiddevchallenge.model.DogUiFactory
import com.example.androiddevchallenge.model.DogUiModel
import com.example.androiddevchallenge.ui.theme.*
import com.example.androiddevchallenge.ui.theme.list.MainActivity.Companion.navigateToDetails

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                TransparentTopAppBar(window)
                MyApp(this)
            }
        }
    }

    companion object {
        const val DOG_ID = "DOG_ID"

        fun navigateToDetails(context: Context, dog:DogUiModel){
            context.startActivity(Intent(context, DogDetailsScreen::class.java).apply {
                putExtra(DOG_ID, dog.id)
            })
        }
    }
}

@Composable
fun MyApp(context: Context) {
    Surface(color = primary, modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header()
            DogList(
                dogs = DogUiFactory.dogList,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                onClick = {
                    navigateToDetails(context, it)
                }
            )
        }
    }
}

@Composable
fun LightPreview(context: Context) {
    MyTheme {
        MyApp(context = context)
    }
}

@Composable
fun DarkPreview(context: Context) {
    MyTheme(darkTheme = true) {
       MyApp(context = context)
    }
}

