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
package com.example.androiddevchallenge.model

import com.example.androiddevchallenge.R

class DogUiFactory {
    companion object {
        val dogList = listOf(
            DogUiModel(0,"Luna", R.drawable.dog_1, "Beagle",  "Loyal, magical, and protector", "1" ,"Female", "White", "4-7"),
            DogUiModel(1, "Kira", R.drawable.dog_2, "Labrador",  "Happy, quiet, and relaxed", "4" ,"Female", "White", "4-7"),
            DogUiModel(2,"Brutus", R.drawable.dog_3, "English Bulldog",  "Protector, heart-mender, and playful", "2 years" ,"Female", "White", "4-7"),
            DogUiModel(3,"Kaffy", R.drawable.dog_4, "Pug",  "Energetic, best friend, and therapist", "2.5" ,"Female", "White", "4-7"),
            DogUiModel(4,"Linda", R.drawable.dog_5, "Jack Russel",  "Love exercise, and stimulation", "5" ,"Female", "White", "4-7"),
        )

        fun getDogById(id:Int): DogUiModel{
            return dogList.elementAt(id)
        }
    }
}