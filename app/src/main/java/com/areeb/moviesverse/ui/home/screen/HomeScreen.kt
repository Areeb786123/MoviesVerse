package com.areeb.moviesverse.ui.home.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.areeb.moviesverse.R
import com.areeb.moviesverse.ui.common.bottombar.BottomBar
import com.areeb.moviesverse.ui.home.viewModels.HomeViewModels

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController) {
    val homeViewModels: HomeViewModels = hiltViewModel()
    homeViewModels.getNowPlaying()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(navHostController)
        },
        containerColor = colorResource(id = R.color.black),
    ) {
        Text(text = "hello")
    }
}
