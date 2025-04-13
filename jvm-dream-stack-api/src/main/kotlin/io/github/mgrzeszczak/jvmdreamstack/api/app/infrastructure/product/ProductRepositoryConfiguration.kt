package io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product

import org.jooq.DSLContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductRepositoryConfiguration {

    @Bean
    fun productRepository(
        dslContext: DSLContext
    ): JooqProductRepository {
        return JooqProductRepository(dslContext)
    }

}