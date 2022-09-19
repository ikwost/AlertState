package com.ikwost.alertstate.navigation

sealed class Screen(val route: String) {
    object Login : Screen(route = "login_screen")
    object Profile : Screen(route = "profile_screen")
    object Map : Screen(route = "map_screen")
}
