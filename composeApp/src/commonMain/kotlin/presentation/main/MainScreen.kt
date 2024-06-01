package presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import data.koinViewModel

@Composable
fun MainScreen(navController: NavController) {

    val viewModel = koinViewModel<MainViewModel>()
    viewModel.addDummyData()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        AsyncImage(
            modifier = Modifier
                .size(250.dp)
                .padding(16.dp).background(Color.Yellow),
            model = "https://media.themoviedb.org/t/p/w440_and_h660_face/czembW0Rk1Ke7lCJGahbOhdCuhV.jpg",
            contentDescription = null,
            onError = {
                println("--------")
                println(it.result)
                println(it)
            }
        )
    }
}