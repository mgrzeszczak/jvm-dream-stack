package io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product

import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.Product
import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.ProductRepository
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.data.redis.core.ReactiveRedisOperations
import java.time.Duration

class RedisProductRepositoryDecorator(
    private val productRepository: ProductRepository,
    private val productRedisOperations: ReactiveRedisOperations<String, Product>
) : ProductRepository by productRepository {

    // TODO: move timeout duration to properties
    override suspend fun findById(id: Long): Product? {
        val key = generateKey(id)
        return productRedisOperations.opsForValue()
            .get(key)
            .awaitFirstOrNull() ?: run {
            productRepository.findById(id)?.let {
                productRedisOperations.opsForValue()
                    .set(key, it, Duration.ofMinutes(5))
                    .awaitSingle()
                it
            }
        }
    }

    private fun generateKey(id: Long): String = "product::$id"

}