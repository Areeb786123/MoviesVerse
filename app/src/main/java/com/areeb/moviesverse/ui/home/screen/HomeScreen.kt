package com.areeb.moviesverse.ui.home.screen

import GetNowPlayingList
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val nowPlayingList = homeViewModels.nowPlaying.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(navHostController)
        },
        containerColor = colorResource(id = R.color.black),
    ) {
        Column {
            Intro()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
            )
            GetNowPlayingList(nowPlayingList,navHostController)
        }
    }
}

@Composable
private fun Intro() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "image",
            modifier = Modifier
                .height(60.dp)
                .width(60.dp)
                .padding(start = 20.dp, top = 20.dp),
        )
        Text(
            text = "Hello",
            fontFamily = FontFamily.Monospace,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 32.dp, start = 10.dp),
        )
        Text(
            text = "Watcher",
            fontFamily = FontFamily.Serif,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 32.dp, start = 2.dp),
        )
    }
}
