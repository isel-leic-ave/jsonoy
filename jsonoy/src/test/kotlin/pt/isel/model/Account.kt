package pt.isel.model

import java.time.LocalDate

class Account(
    val createdDate: LocalDate = LocalDate.now(),
    val accountCode: Short,
    val holderName: String,
    val balance: Long,
    val isActive: Boolean = true,
)
