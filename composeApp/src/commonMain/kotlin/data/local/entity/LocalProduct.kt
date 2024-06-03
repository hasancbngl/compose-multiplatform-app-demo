package data.local.entity

import androidx.room.Entity

@Entity(tableName = "products")
data class LocalProduct(
    val category: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val image: String? = null,
    val price: Double? = null,
    val rating: LocalRating? = null,
    val title: String? = null
)