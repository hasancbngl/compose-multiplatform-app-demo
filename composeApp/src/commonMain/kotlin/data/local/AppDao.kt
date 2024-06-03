package data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import data.local.entity.LocalProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Insert
    suspend fun addLocalProducts(products: List<LocalProduct>)

    @Update
    suspend fun updateLocalProducts(products: List<LocalProduct>)

    @Query("DELETE FROM products WHERE id = :id")
    suspend fun deleteData(id: Int)

    @Query("DELETE FROM products")
    suspend fun clearDB()

    @Query("SELECT * FROM products")
    fun getAllLocalProducts(): Flow<List<LocalProduct>>
}