package com.android.template.navigation

import androidx.navigation.NavController
import com.android.template.R

class Navigator {
    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    fun navigateUp(): Boolean = navController?.navigateUp() ?: false

    fun navigateTo(screen: NavigationScreen) {
        when (screen) {
            is NavigationScreen.BottomSheetScreen -> {

            }

            is NavigationScreen.DetailScreen -> {

            }

            is NavigationScreen.HomeScreen -> {
                navController?.navigate(R.id.action_splashFragment_to_homeFragment)
            }

            is NavigationScreen.SplashScreen -> {
                // Do nothing
            }
        }
    }
}