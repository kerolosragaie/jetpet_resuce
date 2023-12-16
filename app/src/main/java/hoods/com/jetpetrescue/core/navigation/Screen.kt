package hoods.com.jetpetrescue.core.navigation

import hoods.com.jetpetrescue.core.navigation.RoutesConstants.DETAILS_SCREEN
import hoods.com.jetpetrescue.core.navigation.RoutesConstants.HOME_SCREEN
import hoods.com.jetpetrescue.core.navigation.RoutesConstants.PET_ID

sealed class Screen(val route: String) {
    object Home : Screen(route = HOME_SCREEN)
    object Details : Screen(route = "$DETAILS_SCREEN/{$PET_ID}") {
        fun passPetId(petId: Int): String = "$DETAILS_SCREEN/$petId"
    }
}