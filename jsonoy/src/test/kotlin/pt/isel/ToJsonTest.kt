package pt.isel

import com.google.gson.Gson
import org.assertj.core.api.Assertions.assertThat
import pt.isel.model.Address
import pt.isel.model.Classroom
import pt.isel.model.Grade
import pt.isel.model.Person
import pt.isel.model.Student
import kotlin.test.Test

class ToJsonTest {
    private val classroom = buildExpectedClassroom()
    private val gson = Gson()

    @Test
    fun testAddressFieldsToJson() {
        val addr = Address("Oak Avenue", 25, "Porto")
        val json = addr.fieldsToJson().also { println(it) }
        val fromJson = gson.fromJson(json, Address::class.java)
        assertThat(fromJson).usingRecursiveComparison().isEqualTo(addr)
    }

    @Test
    fun testClassroomFieldsToJson() {
        val json = classroom.fieldsToJson().also { println(it) }
        val fromJson = gson.fromJson(json, Classroom::class.java)
        assertThat(fromJson).usingRecursiveComparison().isEqualTo(classroom)
    }

    @Test
    fun testClassroomMembersToJson() {
        val json = classroom.membersToJson().also { println(it) }
        val fromJson = gson.fromJson(json, Classroom::class.java)
        assertThat(fromJson).usingRecursiveComparison().isEqualTo(classroom)
    }

    @Test
    fun testPersonMembersToJson() {
        val alice = Person(id = 1, name = "Alice", born = 946684800000L) // Born: Jan 1, 2000
        val json = alice.membersToJson().also { println(it) }
        val fromJson = gsonPerson.fromJson(json, Person::class.java)
        assertThat(fromJson).usingRecursiveComparison().isEqualTo(alice)
    }

    private fun buildExpectedClassroom(): Classroom =
        Classroom(
            id = "C1",
            students =
                listOf(
                    Student(
                        "Alice",
                        1,
                        "Portugal",
                        Address("Main Street", 10, "Lisbon"),
                        listOf(Grade("Math", 18), Grade("Science", 17)),
                    ),
                    Student(
                        "Bob",
                        2,
                        "Spain",
                        Address("Rose Street", 17, "Lisbon"),
                        listOf(Grade("History", 14), Grade("English", 16)),
                    ),
                    Student("Charlie", 3, "Portugal", Address("Sunset Blvd", 22, "Porto")),
                ),
        )
}
