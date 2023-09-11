package com.areeb.moviesverse.ui.splash

import NetflixIntroAnimation
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.areeb.moviesverse.R
import com.areeb.moviesverse.ui.theme.MoviesVerseTheme
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.App.Companion.IMAGE

@Preview
@Composable
fun SplashScreen() {
    MoviesVerseTheme() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
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
//                Text(
//                    text = "MoviesVerse",
//                    modifier = Modifier.fillMaxWidth()
//                        .scale(1.6f)
//                        .animateContentSize(),
//                    fontSize = 30.sp,
//                    textAlign = TextAlign.Center,
//                    fontStyle = FontStyle.Normal,
//                    fontFamily = FontFamily.Default,
//                )
                NetflixIntroAnimation()
            }
        }
    }
}
