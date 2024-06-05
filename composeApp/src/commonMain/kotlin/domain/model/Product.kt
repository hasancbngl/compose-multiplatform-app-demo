package domain.model

data class Product(
    val id: Int?,
    val category: String?,
    val description: String?,
    val image: String?,
    val price: Double?,
    val rating: Rating?,
    val title: String?
)