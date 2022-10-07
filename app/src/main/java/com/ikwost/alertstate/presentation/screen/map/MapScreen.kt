package com.ikwost.alertstate.presentation.screen.map

import android.Manifest
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.ikwost.alertstate.navigation.Screen
import com.ikwost.alertstate.presentation.screen.map.location.LocationService

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapScreen(navController: NavHostController) {

    val locationPermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
        )
    )
    val context = LocalContext.current

    val serviceStart =
        Intent(context, LocationService::class.java).apply { action = LocationService.ACTION_START }
    val serviceStop =
        Intent(context, LocationService::class.java).apply { action = LocationService.ACTION_STOP }


    LaunchedEffect(key1 = Lifecycle.Event.ON_CREATE, block = {
        locationPermissionsState.launchMultiplePermissionRequest()
    })


    Scaffold {
        Column {


            Button(
                onClick = { navController.navigate(route = Screen.Profile.route) },
            ) {
                Text("Profile Screen")
            }
            Button(
                onClick = { context.startService(serviceStart) },
            ) {
                Text("Location Service Start")
            }
            Button(
                onClick = {context.startService(serviceStop) },
            ) {
                Text("Location Service Start")
            }
        }

    }
}