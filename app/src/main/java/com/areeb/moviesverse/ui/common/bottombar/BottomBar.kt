package com.areeb.moviesverse.ui.common.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.areeb.moviesverse.R
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.App.Companion.IMAGE
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.Navigations.Companion.CATEGORY
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.Navigations.Companion.HOME
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.Navigations.Companion.SEARCH

@Composable
fun BottomBar(navHostController: NavHostController) {
    val navBackStackEntry = navHostController.currentBackStackEntry

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp, 20.dp, 20.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth(),
            containerColor = colorResource(id = R.color.black),
            contentColor = colorResource(id = R.color.blood_red),

        ) {
            navigationList().forEach { item ->
                val currentDestination = navBackStackEntry?.destination
                NavigationBarItem(
                    modifier = Modifier.background(colorResource(id = R.color.blood_red)),
                    selected = item.route == currentDestination?.route,
                    onClick = {
                        navHostController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            imageVector = item.image,
                            contentDescription = IMAGE,
                            tint = colorResource(
                                id = R.color.black,
                            ),
                        )
                    },
                )
            }
        }
    }
}

@Composable
private fun navigationList(): List<BottomNavigationObj> {
    return listOf(
        BottomNavigationObj(
            title = "",
            route = HOME,
            image = ImageVector.vectorResource(id = R.drawable.ic_home),
        ),
        BottomNavigationObj(
            title = "",
            route = SEARCH,
            image = ImageVector.vectorResource(id = R.drawable.ic_search),
        ),
        BottomNavigationObj(
            title = "",
            route = CATEGORY,
            image = ImageVector.vectorResource(id = R.drawable.ic_category),
        ),
    )
}
