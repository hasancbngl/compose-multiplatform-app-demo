package presentation.detail

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import data.koinViewModel

@Composable
fun DetailScreen(navController: NavController) {

    val viewModel = koinViewModel<DetailViewModel>()
}