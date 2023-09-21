package com.areeb.moviesverse.ui.detail.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navigationHostController: NavHostController, movieId: Int? = 0) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
        Text(text = movieId.toString(), fontSize = 40.sp)
    }
}
