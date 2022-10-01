package com.ikwost.alertstate.presentation.screen.map

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.ikwost.alertstate.navigation.Screen

@Composable
fun MapScreen(navController: NavHostController) {
    Scaffold {
        Column {
            Text(
                text = "Hello Map",

                )
            Button(
                onClick = { navController.navigate(route = Screen.Profile.route) }) {

            }
        }

    }
}