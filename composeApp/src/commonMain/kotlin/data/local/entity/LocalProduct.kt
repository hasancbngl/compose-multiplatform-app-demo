package data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "products")
data class LocalProduct(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val category: String? = null,
    val description: String? = null,
    val image: String? = null,
    val price: Double? = null,
    val rating: LocalRating? = null,
    val title: String? = null
)