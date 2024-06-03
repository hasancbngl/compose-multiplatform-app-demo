package data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteProduct(
    @SerialName("category")
    val category: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("price")
    val price: Double? = null,
    @SerialName("rating")
    val rating: RemoteRating? = null,
    @SerialName("title")
    val title: String? = null
)