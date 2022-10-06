package com.ikwost.alertstate.presentation.screen.map

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ikwost.alertstate.navigation.Screen

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapScreen(navController: NavHostController) {





    Scaffold {
        Column {
            Text(
                text = "Hello Map",
            )
            Button(
                onClick = { navController.navigate(route = Screen.Profile.route) },
            ) {
                Text("Profile Screen")
            }
            Button(
                onClick = { },
            ) {
                Text("Location")
            }
        }

    }
}