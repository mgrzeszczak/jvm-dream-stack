/*
 * This file is generated by jOOQ.
 */
package io.github.mgrzeszczak.jvmdreamstack.api.jooq.keys


import io.github.mgrzeszczak.jvmdreamstack.api.jooq.tables.FlywaySchemaHistory
import io.github.mgrzeszczak.jvmdreamstack.api.jooq.tables.Product
import io.github.mgrzeszczak.jvmdreamstack.api.jooq.tables.records.FlywaySchemaHistoryRecord
import io.github.mgrzeszczak.jvmdreamstack.api.jooq.tables.records.ProductRecord

import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal


// -------------------------------------------------------------------------
// UNIQUE and PRIMARY KEY definitions
// -------------------------------------------------------------------------

val FLYWAY_SCHEMA_HISTORY_PK: UniqueKey<FlywaySchemaHistoryRecord> = Internal.createUniqueKey(
    FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
    DSL.name("flyway_schema_history_pk"),
    arrayOf(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK),
    true
)
val PRODUCT_PKEY: UniqueKey<ProductRecord> =
    Internal.createUniqueKey(Product.PRODUCT, DSL.name("product_pkey"), arrayOf(Product.PRODUCT.ID), true)
