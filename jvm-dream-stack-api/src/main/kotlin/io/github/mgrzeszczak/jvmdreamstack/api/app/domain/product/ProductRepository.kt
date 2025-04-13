package io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product

interface ProductRepository {

    suspend fun findById(id: Long): Product?

    suspend fun insert(pendingProduct: PendingProduct): Long

}

data class PendingProduct(
    val name: String
)