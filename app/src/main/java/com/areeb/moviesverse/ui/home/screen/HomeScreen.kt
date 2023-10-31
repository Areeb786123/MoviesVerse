package com.areeb.moviesverse.ui.home.screen

import FilterDialog
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.areeb.moviesverse.R
import com.areeb.moviesverse.data.models.request.nowPlaying.Result
import com.areeb.moviesverse.ui.common.bottombar.BottomBar
import com.areeb.moviesverse.ui.home.viewModels.HomeViewModels
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.API.Companion.BASE_IMAGE_LOAD
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.Navigations.Companion.DETAIL
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

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
            GetNowPlayingList(nowPlayingList, navHostController)
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

@Composable
private fun GetNowPlayingList(
    nowPlayingList: State<List<Result>>,
    navHostController: NavHostController,
) {
    val context = LocalContext.current
    var isDialogVisible by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(modifier = Modifier.wrapContentWidth()) {
                Text(
                    text = "Up",
                    fontSize = 28.sp,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                    fontFamily = FontFamily.Monospace,
                    color = colorResource(
                        id = R.color.white,
                    ),
                )

                Text(
                    text = "Coming",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(top = 10.dp),
                    fontFamily = FontFamily.Monospace,
                    color = colorResource(
                        id = R.color.white,
                    ),
                )
            }
            Image(
                painter = painterResource(id = R.drawable.baseline_filter_list_24),
                contentDescription = "image",
                modifier = Modifier
                    .width(40.dp)
                    .height(34.dp)
                    .clickable {
                        Toast
                            .makeText(context, "filter", Toast.LENGTH_SHORT)
                            .show()
                        isDialogVisible = true
                    },
            )
            if (isDialogVisible) {
                FilterDialog(
                    showDialog = {
                        isDialogVisible = it
                    },
                )
            }
        }

        if (nowPlayingList.value.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black), // Background color of the layout
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    color = colorResource(id = R.color.blood_red),
                    strokeWidth = 4.dp,
                )
            }
        } else {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
            ) {
                items(nowPlayingList.value) {
                    NowPlayingMovingList(it, navHostController)
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NowPlayingMovingList(result: Result, navHostController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(
                top = 30.dp,
                start = 10.dp,
                end = 16.dp,
                bottom = 120.dp,
            )
            .clip(RoundedCornerShape(12.dp))
            .fillMaxSize(),
        onClick = {
            navHostController.navigate("$DETAIL/${result.id}")
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .fillMaxSize(),
        ) {
            GlideImage(
                model = "$BASE_IMAGE_LOAD${result.poster_path}",
                contentDescription = "image",
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
            ) {
                it.load("$BASE_IMAGE_LOAD${result.poster_path}")
            }
            Text(text = result.title)
        }
    }
}
