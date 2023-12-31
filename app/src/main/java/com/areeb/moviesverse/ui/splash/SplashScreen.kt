package com.areeb.moviesverse.ui.splash

import NetflixIntroAnimation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.areeb.moviesverse.R
import com.areeb.moviesverse.ui.theme.MoviesVerseTheme
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.App.Companion.IMAGE
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.Navigations.Companion.HOME
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController) {
    MoviesVerseTheme() {
        Box(
            modifier = Modifier.fillMaxSize().background(colorResource(id = R.color.black)),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.app_icons),
                    contentDescription = IMAGE,
                )
                Spacer(modifier = Modifier.size(10.dp))

                NetflixIntroAnimation()

                LaunchedEffect(key1 = Unit) {
                    delay(2000)
                    navHostController.navigate(HOME)
                }
            }
        }
    }
}
