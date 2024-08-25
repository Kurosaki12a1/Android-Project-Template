package com.android.template.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.android.template.R
import com.android.template.databinding.ActivityMainBinding
import com.android.template.navigation.NavigationScreen
import com.android.template.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navigator: Navigator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavController()
    }

    private fun setUpNavController() {
        navigator = Navigator()
        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHost.navController
        navigator?.setNavController(navController)
    }

    fun navigateTo(screen: NavigationScreen) {
        navigator?.navigateTo(screen)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigator?.navigateUp() ?: false || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        navigator = null
    }
}