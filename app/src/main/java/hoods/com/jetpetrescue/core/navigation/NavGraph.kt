package hoods.com.jetpetrescue.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import hoods.com.jetpetrescue.core.navigation.RoutesConstants.DETAILS_SCREEN
import hoods.com.jetpetrescue.core.navigation.RoutesConstants.PET_ID
import hoods.com.jetpetrescue.core.screens.LoadingScreen
import hoods.com.jetpetrescue.core.utils.openUrl
import hoods.com.jetpetrescue.features.home.presentation.screens.details.DetailsScreen
import hoods.com.jetpetrescue.features.home.presentation.screens.home.HomeScreen
import hoods.com.jetpetrescue.features.home.presentation.screens.home.HomeViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    onThemeChange: () -> Unit,
    homeViewModel: HomeViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(
            route = Screen.Home.route,
        ) {
            HomeScreen(
                onSwitchToggle = onThemeChange,
                onPetItemClicked = { petId ->
                    navController.navigate(
                        Screen.Details.passPetId(petId)
                    )
                },
                homeViewModel = homeViewModel,
            )
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(PET_ID) { type = NavType.IntType },
            ),
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://www.likander.com/$DETAILS_SCREEN/{$PET_ID}"
                },
            ),
        ) { backStackEntry ->
            val petId = backStackEntry.arguments?.getInt(PET_ID)!!
            val selectedPet = homeViewModel.uiState.animals.data?.get(petId)
            val context = LocalContext.current

            if (selectedPet != null) {
                DetailsScreen(
                    animal = selectedPet,
                    onClickArrowBack = {
                        navController.navigateUp()
                    },
                    onClickAdopt = {
                        openUrl(
                            context = context,
                            url = selectedPet.url,
                        )
                    },
                )
            } else {
                LoadingScreen()
            }

        }
    }
}