package io.github.mgrzeszczak.jvmdreamstack.api.app.infrastructure.product

import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.PendingProduct
import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.Product
import io.github.mgrzeszczak.jvmdreamstack.api.app.domain.product.ProductRepository
import io.github.mgrzeszczak.jvmdreamstack.api.jooq.tables.references.PRODUCT
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.awaitSingle
import org.jooq.DSLContext
import org.springframework.transaction.annotation.Transactional

@Transactional
class JooqProductRepository(
    private val dslContext: DSLContext
) : ProductRepository {

    override suspend fun findById(id: Long): Product? {
        return dslContext.selectFrom(PRODUCT)
            .where(PRODUCT.ID.eq(id))
            .awaitFirstOrNull()?.let { record ->
                Product(
                    record.id!!,
                    record.name
                )
            }
    }

    override suspend fun insert(pendingProduct: PendingProduct): Long {
        return dslContext.insertInto(PRODUCT)
            .set(PRODUCT.NAME, pendingProduct.name)
            .returning(PRODUCT.ID)
            .awaitSingle().let { record -> record.id!! }
    }

}