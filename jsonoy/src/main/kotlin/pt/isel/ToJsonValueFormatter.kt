package pt.isel

interface ToJsonValueFormatter {
    fun format(value: Any): String
}
