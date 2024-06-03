package data

import android.content.Context
import data.local.AppDatabase
import data.local.getDatabaseBuilder
import data.local.getRoomDatabase
import data.repository.AppRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

actual class KoinInitializer(
    private val context: Context
) {
    actual fun init() {
        startKoin {
            modules(viewModelModule, module {
                androidContext(context)
                androidLogger()
                single { getDatabaseBuilder(androidContext()) }
                single { getRoomDatabase(get()) }
                single { get<AppDatabase>().dao() }
                single { AppRepository(get(), get()) }
                single {
                    HttpClient {
                        install(ContentNegotiation) {
                            json(Json {
                                prettyPrint = true
                                ignoreUnknownKeys = true
                            })
                        }
                    }
                }
            })
        }
    }
}