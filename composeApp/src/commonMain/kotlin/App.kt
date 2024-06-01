import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.LocalPlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import navigation.SetupNavGraph
import okio.FileSystem
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App() {

    val lightColors = lightColorScheme(
        primary = Color.Gray,
        onPrimary = Color.LightGray,
        primaryContainer = Color.Gray,
        onPrimaryContainer = Color.LightGray
    )
    val darkColors = darkColorScheme(
        primary = Color.Gray,
        onPrimary = Color.LightGray,
        primaryContainer = Color.Gray,
        onPrimaryContainer = Color.LightGray
    )
    val colors by mutableStateOf(
        if (isSystemInDarkTheme()) darkColors else lightColors
    )
    val c = LocalPlatformContext.current

    MaterialTheme(colorScheme = colors) {
        val navController = rememberNavController()
        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(c)
        }
        SetupNavGraph(navController)
    }
}

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context)
        .dispatcher(Dispatchers.IO).memoryCachePolicy(CachePolicy.ENABLED).memoryCache {
        MemoryCache.Builder().maxSizePercent(context, 0.3).strongReferencesEnabled(true).build()
    }.diskCachePolicy(CachePolicy.ENABLED).networkCachePolicy(CachePolicy.ENABLED).diskCache {
        newDiskCache()
    }.crossfade(true).logger(DebugLogger()).build()

fun newDiskCache(): DiskCache {
    return DiskCache.Builder().directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache")
        .maxSizeBytes(1024L * 1024 * 1024) // 512MB
        .build()
}