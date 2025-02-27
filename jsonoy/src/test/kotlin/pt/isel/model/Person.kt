package pt.isel.model

import pt.isel.ToJsonFormatter
import pt.isel.ToJsonPropName
import pt.isel.ToJsonValueFormatter
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit

val personDateFormatter = SimpleDateFormat("dd-MM-yyyy")

class DateFormatter : ToJsonValueFormatter {
    override fun format(value: Any): String = personDateFormatter.format(java.util.Date(value as Long))
}

class Person(
    @ToJsonPropName("person_id")
    val id: Int,
    val name: String,
    @ToJsonPropName("born")
    @ToJsonFormatter(DateFormatter::class)
    val born: Long,
) {
    fun age(): Int {
        val birthDate = Instant.ofEpochMilli(born).atZone(ZoneId.systemDefault()).toLocalDate()
        val today = LocalDate.now()
        return ChronoUnit.YEARS.between(birthDate, today).toInt()
    }
}
