package presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import data.koinViewModel

@Composable
fun MainScreen(navController: NavController) {
    val viewModel = koinViewModel<MainViewModel>()
    val products = viewModel.products.value













//        AsyncImage(
//            modifier = Modifier
//                .size(250.dp)
//                .padding(16.dp).background(Color.Yellow),
//            model = "https://media.themoviedb.org/t/p/w440_and_h660_face/czembW0Rk1Ke7lCJGahbOhdCuhV.jpg",
//            contentDescription = null,
//            onError = {
//                println("--------")
//                println(it.result)
//                println(it)
//            }
//        )
}