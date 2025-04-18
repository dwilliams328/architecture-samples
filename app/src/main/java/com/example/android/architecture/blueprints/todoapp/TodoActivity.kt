/*
 * Copyright 2019 The Android Open Source Project
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

package com.example.android.architecture.blueprints.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity for the todoapp
 */
@AndroidEntryPoint
class TodoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
//                TodoNavGraph()
//                CustomCard("My Title")
//                CustomButton({}, "My Title")
//                BoxExample()
                SurfaceExample()

            }
        }
    }
}

/**
 * Surface Composable is a wrapper that gives shape, color, elevation, and interaction behavior (like ripple effects) to content.
 * It’s a common container used to build things like cards, buttons, dialogs, and even the background of your app.
 */
@Composable
fun CustomCard(
    title: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 4.dp,
        shadowElevation = 2.dp,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(24.dp),
        color = MaterialTheme.colorScheme.primary,
        onClick = onClick, // This turns it into an interactive surface
        modifier = modifier
            .height(48.dp)
            .wrapContentWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

/**
 * Surface Vs Box
 * Material3 color from colorScheme.surfaceVariant
 * Elevation handled for you (tonal + shadow)
 * Ripple + accessibility if onClick is provided
 * Proper content color for text (auto-applied if you don’t override)
 */
@Composable
fun SurfaceExample() {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        tonalElevation = 4.dp,
        shadowElevation = 2.dp,
        onClick = { /* Do something */ }, // Optional click!
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            "I'm a Surface!",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Gray)
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text("I'm just a Box", color = Color.White)
    }
}



