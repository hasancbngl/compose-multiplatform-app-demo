package data

import data.local.AppDatabase
import data.local.getDatabaseBuilder
import data.local.getRoomDatabase
import data.repository.AppRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.module

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(viewModelModule, module {
                // Define the database builder without context
                single { getDatabaseBuilder() }
                single { getRoomDatabase(get()) }
                single { get<AppDatabase>().dao() }
                factory {
                    HttpClient {
                        install(ContentNegotiation) {
                            json(Json {
                                prettyPrint = true
                                ignoreUnknownKeys = true
                            })
                        }
                    }
                }
                // Repository and ViewModels
                factory { AppRepository(get(), get()) }
            })
        }
    }
}