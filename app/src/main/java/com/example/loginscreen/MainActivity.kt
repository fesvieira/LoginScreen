package com.example.loginscreen

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.loginscreen.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // Instantiate nav controller class to use it
    private lateinit var navController: NavController

    // Binding
    private lateinit var binding: ActivityMainBinding

    // appBar is used for bottom nav and nav drawer
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Configure bottom navigation and drawer, set destinations for better navigation
           if not configured, it will be back arrows in menus off bottom navigation
         */
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentHome, R.id.searchFragment),
            binding.drawerLayout
        )

        // Define Fragments controller
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Definition off navigation controller
        navController = navHostFragment.findNavController()

        // Action bar configuration
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Configures the bottom navigation
        binding.bottomNav.setupWithNavController(navController)

        // Configures the nav drawer
        binding.navView.setupWithNavController(navController)
    }

    // Makes the button off navigation bar go back to previous fragment
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // Inflate the menu list when click on Options Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    // Receive menu item clicked and goes to it destination
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }


}