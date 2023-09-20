package com.areeb.moviesverse.ui.common.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.areeb.moviesverse.ui.categories.screen.CategoryScreen
import com.areeb.moviesverse.ui.home.screen.HomeScreen
import com.areeb.moviesverse.ui.search.screen.SearchScreen
import com.areeb.moviesverse.ui.splash.SplashScreen
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.Navigations.Companion.CATEGORY
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.Navigations.Companion.HOME
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.Navigations.Companion.SEARCH
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.Navigations.Companion.SPLASH

@Composable
fun NavigationHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = SPLASH) {
        composable(route = SPLASH) {
            SplashScreen(navHostController)
        }
        composable(route = HOME) {
            HomeScreen(navHostController)
        }
        composable(route = CATEGORY) {
            CategoryScreen(navHostController = navHostController)
        }
        composable(route = SEARCH) {
            SearchScreen(navHostController = navHostController)
        }
    }
}
