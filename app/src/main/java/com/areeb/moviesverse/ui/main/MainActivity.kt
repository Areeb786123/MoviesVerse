package com.areeb.moviesverse.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.colorResource
import com.areeb.moviesverse.R
import com.areeb.moviesverse.ui.splash.SplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(colorResource(id = R.color.blood_red))
            SplashScreen()
        }
    }
}
