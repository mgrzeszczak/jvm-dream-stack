/*
 * This file is generated by jOOQ.
 */
package io.github.mgrzeszczak.jvmdreamstack.api.jooq.tables


import io.github.mgrzeszczak.jvmdreamstack.api.jooq.Public
import io.github.mgrzeszczak.jvmdreamstack.api.jooq.keys.PRODUCT_PKEY
import io.github.mgrzeszczak.jvmdreamstack.api.jooq.tables.records.ProductRecord
import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Product(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, ProductRecord>?,
    parentPath: InverseForeignKey<out Record, ProductRecord>?,
    aliased: Table<ProductRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<ProductRecord>(
    alias,
    Public.PUBLIC,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    companion object {

        /**
         * The reference instance of <code>public.product</code>
         */
        val PRODUCT: Product = Product()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ProductRecord> = ProductRecord::class.java

    /**
     * The column <code>public.product.id</code>.
     */
    val ID: TableField<ProductRecord, Long?> =
        createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.product.name</code>.
     */
    val NAME: TableField<ProductRecord, String?> =
        createField(DSL.name("name"), SQLDataType.VARCHAR(512).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<ProductRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<ProductRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<ProductRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.product</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.product</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.product</code> table reference
     */
    constructor() : this(DSL.name("product"), null)

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<ProductRecord, Long?> = super.getIdentity() as Identity<ProductRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<ProductRecord> = PRODUCT_PKEY
    override fun `as`(alias: String): Product = Product(DSL.name(alias), this)
    override fun `as`(alias: Name): Product = Product(alias, this)
    override fun `as`(alias: Table<*>): Product = Product(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Product = Product(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Product = Product(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Product = Product(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Product =
        Product(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Product = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Product = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Product = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): Product = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): Product = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): Product =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): Product =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Product = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Product = where(DSL.notExists(select))
}
