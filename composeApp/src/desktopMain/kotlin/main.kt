import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.KoinInitializer

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose Multiplatform News App",
    ) {
        KoinInitializer().init()
        App()
    }
}