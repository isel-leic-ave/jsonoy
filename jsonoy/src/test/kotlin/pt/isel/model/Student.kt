package pt.isel.model

class Student(
    val name: String,
    val nr: Int,
    val from: String,
    val address: Address,
    val grades: List<Grade> = emptyList(),
)
