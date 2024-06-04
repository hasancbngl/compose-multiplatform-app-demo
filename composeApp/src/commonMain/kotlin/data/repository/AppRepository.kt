package data.repository

import data.local.AppDao
import data.local.entity.LocalProduct
import data.remote.RemoteProduct
import domain.model.Product
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AppRepository(
    private val appDao: AppDao,
    private val httpClient: HttpClient
) {

    suspend fun addProducts(products: List<RemoteProduct>) {
      //  appDao.addLocalProducts(products)
    }

    suspend fun updateTask(products: List<RemoteProduct>) {
       // appDao.updateLocalProducts()
    }

    suspend fun deleteProducts() {
        try {
            appDao.clearDB()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readData(): Flow<List<Product>> {
      //  return appDao.getAllLocalProducts()
        return flowOf(emptyList())
    }
}