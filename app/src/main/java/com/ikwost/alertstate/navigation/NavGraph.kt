package com.ikwost.alertstate.navigation

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ikwost.alertstate.presentation.screen.login.LoginScreen
import com.ikwost.alertstate.presentation.screen.map.MapScreen
import com.ikwost.alertstate.presentation.screen.map.Sample
import com.ikwost.alertstate.presentation.screen.profile.ProfileScreen

@OptIn(ExperimentalPermissionsApi::class)
@ExperimentalCoilApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.Map.route) {
            MapScreen(navController = navController)
            Sample()

        }
    }
}