package com.example.dao

import com.example.models.Product
import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.*
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DAOFacadeImpl : DAOFacade {

    private fun resultRowToProduct(row: ResultRow) =
        Product(
        id = row[Products.id],
        name = row[Products.name],
        category = row[Products.category],
        country = row[Products.country],
    )


    override suspend fun allProducts(): List<Product> = dbQuery {
        Products.selectAll().map(::resultRowToProduct)
    }

    override suspend fun product(id: Int): Product? = dbQuery {
        Products
            .select { Products.id eq id }
            .map(::resultRowToProduct)
            .singleOrNull()
    }

    override suspend fun addNewProduct( name: String, category: Int, country: String): Product? = dbQuery {
        val insertStatement = Products.insert {
            it[Products.name] = name
            it[Products.category] = category
            it[Products.country] = country
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToProduct)
    }

    override suspend fun editProduct(id: Int, name: String, category: Int, country: String): Boolean = dbQuery {
        Products.update({ Products.id eq id }) {
            it[Products.name] = name
            it[Products.category] = category
            it[Products.country] = country
        } > 0
    }

    override suspend fun deleteProduct(id: Int): Boolean = dbQuery {
        Products.deleteWhere { Products.id eq id } > 0
    }

    private fun resultRowToCategory(row: ResultRow) = Category(
        id = row[Categories.id],
        name = row[Categories.name],
        type = row[Categories.type],
        eco = row[Categories.eco],
    )

    override suspend fun allCategories(): List<Category> = dbQuery {
        Categories.selectAll().map(::resultRowToCategory)
    }

    override suspend fun category(id: Int): Category? = dbQuery {
        Categories
            .select { Categories.id eq id }
            .map(::resultRowToCategory)
            .singleOrNull()
    }

    override suspend fun addNewCategory(name: String, type: Boolean, eco: Boolean): Category? = dbQuery {
        val insertStatement = Categories.insert {
            it[Categories.name] = name
            it[Categories.type] = type
            it[Categories.eco] = eco
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToCategory)
    }

    override suspend fun editCategory(id: Int, name: String, type: Boolean, eco: Boolean): Boolean = dbQuery {
        Categories.update({ Categories.id eq id }) {
            it[Categories.name] = name
            it[Categories.type] = type
            it[Categories.eco] = eco
        } > 0
    }

    override suspend fun deleteCategory(id: Int): Boolean = dbQuery {
        Categories.deleteWhere { Categories.id eq id } > 0
    }

}

val dao: DAOFacade = DAOFacadeImpl().apply {

    runBlocking {

        if(allProducts().isEmpty()) { // NIE JEST EMPTY TRZEBA POGRZEBAC W BAZIE I WYWALICP OPRZEDNEI REKODRY
                                        // DODATKWOOW JSON JEST TYLKO DO TEKSTU I TRZEBA ZRUTOWAC INTY
            addNewCategory("Fridge", false, false)
            addNewCategory("TV", true, false)
            addNewProduct("LG-fridge", 1, "Japan")
            addNewProduct("Amica-fridge", 1, "Japan")

        }
    }
}