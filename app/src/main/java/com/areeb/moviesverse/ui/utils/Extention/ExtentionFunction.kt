package com.areeb.moviesverse.ui.utils.Extention

import android.view.View
import android.view.Window

fun fullScreen(window: Window) {
    // Hide the status bar and the navigation bar
    window.decorView.systemUiVisibility =
        (View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
}
