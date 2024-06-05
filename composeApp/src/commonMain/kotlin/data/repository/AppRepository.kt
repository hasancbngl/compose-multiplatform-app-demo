package data.repository

import data.local.AppDao
import data.remote.RemoteProduct
import domain.model.Product
import domain.toLocalProducts
import domain.toProducts
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppRepository(
    private val appDao: AppDao,
    private val httpClient: HttpClient
) {

    suspend fun getAllProducts(): Flow<List<Product>> {
        refreshProductsData()
        delay(200)
        val productsFromDb = appDao.getAllLocalProducts().map { list->
            list.toProducts()
        }
        return productsFromDb
    }

    private suspend fun refreshProductsData() {
        val response = httpClient.get("https://fakestoreapi.com/products")
        val remoteProducts = response.body<List<RemoteProduct>>()
        if (remoteProducts.isNotEmpty()) {
            appDao.clearDB()
            delay(300)
            appDao.addLocalProducts(remoteProducts.toLocalProducts())
        }
    }
}