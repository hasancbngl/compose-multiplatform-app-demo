package data.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class LocalRating(
    val count: Int? = null,
    val rate: Double? = null
)