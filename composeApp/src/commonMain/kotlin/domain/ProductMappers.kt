package domain

import data.local.entity.LocalProduct
import data.local.entity.LocalRating
import data.remote.RemoteProduct
import domain.model.Product
import domain.model.Rating

fun List<LocalProduct>.toProducts(): List<Product> {
    return map { localProduct ->
        Product(
            id = localProduct.id,
            rating = Rating(
                count = localProduct.rating?.count,
                rate = localProduct.rating?.rate
            ),
            category = localProduct.category,
            image = localProduct.image,
            description = localProduct.description,
            title = localProduct.title,
            price = localProduct.price
        )
    }
}

fun List<RemoteProduct>.toLocalProducts(): List<LocalProduct> {
    return map { product ->
        LocalProduct(
            id = product.id,
            rating = LocalRating(
                count = product.rating?.count,
                rate = product.rating?.rate
            ),
            category = product.category,
            image = product.image,
            description = product.description,
            title = product.title,
            price = product.price
        )
    }
}