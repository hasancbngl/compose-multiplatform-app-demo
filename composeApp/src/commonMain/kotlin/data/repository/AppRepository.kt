package data.repository

import data.local.AppDao
import domain.AppEntity
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

class AppRepository(
    private val appDao: AppDao,
    private val httpClient: HttpClient
) {

    suspend fun addData(appEntity: AppEntity) {
        appDao.addData(appEntity)
    }

    suspend fun updateTask(appEntity: AppEntity) {
        appDao.updateData(appEntity)
    }

    suspend fun deleteData(id: Int) {
        try {
            appDao.deleteData(id)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readData(): Flow<List<AppEntity>> {
        return appDao.readData()
    }
}