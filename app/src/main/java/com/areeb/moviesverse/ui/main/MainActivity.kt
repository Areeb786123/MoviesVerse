package com.areeb.moviesverse.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.areeb.moviesverse.R
import com.areeb.moviesverse.ui.common.Navigations.NavigationHost
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(colorResource(id = R.color.blood_red))
            val navHostController = rememberNavController()
            NavigationHost(navHostController = navHostController)
        }
    }
}
