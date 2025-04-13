package io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product

class ProductFacade(
    private val productRepository: ProductRepository,
) {

    suspend fun findById(id: Long): Product? {
        return productRepository.findById(id)
    }

    suspend fun create(pendingProduct: PendingProduct): Long {
        return productRepository.insert(pendingProduct)
    }

}