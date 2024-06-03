package data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteRating(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("rate")
    val rate: Double? = null
)