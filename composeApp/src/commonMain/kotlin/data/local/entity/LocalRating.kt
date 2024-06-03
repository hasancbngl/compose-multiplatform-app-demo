package data.local.entity

import androidx.room.ColumnInfo

data class LocalRating(
    val count: Int? = null,
    val rate: Double? = null,
    @ColumnInfo("master_product_id")
    val masterProductId: String,
)