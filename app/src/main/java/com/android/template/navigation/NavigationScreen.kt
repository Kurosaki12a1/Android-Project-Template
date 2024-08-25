package com.android.template.navigation

sealed interface NavigationScreen {
    data object SplashScreen : NavigationScreen
    data object HomeScreen : NavigationScreen
    data object DetailScreen : NavigationScreen

    data class BottomSheetScreen(val title: String) : NavigationScreen
}