package io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product.dto

import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.Product

data class ProductResponse(val id: Long, val name: String) {

    companion object {
        fun fromDomain(product: Product): ProductResponse {
            return ProductResponse(product.id, product.name)
        }
    }

}