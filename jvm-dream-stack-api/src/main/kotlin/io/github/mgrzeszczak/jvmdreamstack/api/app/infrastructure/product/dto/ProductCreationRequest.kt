package io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product.dto

import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.PendingProduct

data class ProductCreationRequest(val name: String) {

    fun toDomain() = PendingProduct(name)

}