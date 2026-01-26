package com.example.hw2_androidstudio.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.hw2_androidstudio.screens.*
import com.example.hw2_androidstudio.viewmodel.CalculatorViewModel

@Composable
fun AppNavigation(viewModel: CalculatorViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                onStart = { navController.navigate("input") },
                onHistory = { navController.navigate("history") }
            )
        }

        composable("input") {
            InputScreen(
                viewModel = viewModel,
                onCalculate = { id ->
                    navController.navigate("result/$id")
                }
            )
        }

        composable(
            route = "result/{calcId}",
            arguments = listOf(
                navArgument("calcId") { type = NavType.IntType }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments!!.getInt("calcId")

            ResultScreen(
                calculation = viewModel.getCalculation(id),
                onBack = { navController.popBackStack() },
                onNew = {
                    viewModel.reset()
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }

        composable("history") {
            HistoryScreen(
                history = viewModel.getHistory(),
                onBack = { navController.popBackStack() }
            )
        }
    }
}
