package io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.Product
import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.ProductFacade
import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.ProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
@Import(ProductRepositoryConfiguration::class)
class ProductConfiguration {

    @Bean
    fun productFacade(
        productRepository: ProductRepository,
    ): ProductFacade {
        return ProductFacade(
            productRepository
        )
    }

    @Bean
    fun productRedisOperations(
        factory: ReactiveRedisConnectionFactory,
        objectMapper: ObjectMapper
    ): ReactiveRedisOperations<String, Product> {
        val serializationContext =
            RedisSerializationContext.newSerializationContext<String, Product>(StringRedisSerializer())
                .value(Jackson2JsonRedisSerializer(objectMapper, Product::class.java))
                .build()
        return ReactiveRedisTemplate<String, Product>(factory, serializationContext)
    }

    @Bean
    @Primary
    fun redisProductRepository(
        productRepository: ProductRepository,
        productRedisOperations: ReactiveRedisOperations<String, Product>
    ): RedisProductRepositoryDecorator {
        return RedisProductRepositoryDecorator(
            productRepository,
            productRedisOperations
        )
    }

}