package io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product

import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.ProductFacade
import io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product.dto.ProductCreationRequest
import io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product.dto.ProductCreationResponse
import io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product.dto.ProductResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productFacade: ProductFacade
) {

    @GetMapping("/{id}")
    suspend fun findById(@PathVariable id: Long): ResponseEntity<ProductResponse> {
        return productFacade.findById(id)?.let {
            ResponseEntity.ok()
                .body(ProductResponse.fromDomain(it))
        } ?: ResponseEntity.notFound().build<ProductResponse>()
    }

    @PostMapping
    suspend fun create(@RequestBody request: ProductCreationRequest): ResponseEntity<ProductCreationResponse> {
        return productFacade.create(request.toDomain()).let { id ->
            ResponseEntity.ok()
                .body(ProductCreationResponse(id))
        }
    }

}