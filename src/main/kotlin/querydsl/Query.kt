package querydsl


interface Eval {
    fun eval(): String
}

class Select : Eval {

    val columns: MutableList<Column> = mutableListOf()

    fun column(name: String): Column {
        val column = Column(name)
        columns.add(column)
        return column
    }

    override fun eval() = "SELECT ${columns.asSequence().joinToString { it.name }}"
}

class Where : Eval {
    override fun eval() =
        "WHERE ${conditions.asSequence().joinToString(separator = " AND ", prefix = "( ", postfix = " )") { it.cond }}"

    val conditions: MutableList<Condition> = mutableListOf()

    fun condition(condition: String): Unit {
        val condition = Condition(condition)
        conditions.add(condition)
    }
}

data class Column(val name: String)
data class Condition(val cond: String)

class Query : Eval {
    lateinit var select: Select
    lateinit var from: String

    var where: Where? = null

    fun select(fn: Select.() -> Unit): Unit {
        select = Select()
        select.fn()
    }

    fun from(table: String) {
        from = table;
    }

    fun where(fn: Where.() -> Unit): Unit {
        where = Where()
        where?.fn()
    }

    override fun eval(): String {
        var query = "${select.eval()} FROM $from"
        if (where != null) {
            query += " WHERE ${where?.eval()}"
        }
        return query
    }
}

fun query(fn: Query.() -> Unit): Query {
    val query = Query()
    query.fn()
    return query
}


fun main() {
    val query = query {
        select {
            column("name")
            column("lastname")
            column("age")
        }
        from("MY_TABLE")
        where {
            condition("name == 'Paperino'")
            condition("lastname == 'Paolino'")
            condition("age = 12")
        }
    }
    println(" Query: ${query.eval()}")
}