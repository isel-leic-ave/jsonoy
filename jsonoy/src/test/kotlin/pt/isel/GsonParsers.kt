package pt.isel

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import pt.isel.model.personDateFormatter
import java.lang.reflect.Field

val gsonPerson: Gson =
    GsonBuilder()
        .setFieldNamingStrategy { field: Field ->
            when (field.name) {
                "id" -> "person_id"
                else -> field.name
            }
        }.registerTypeAdapter(
            Long::class.java,
            JsonDeserializer { json, _, _ ->
                personDateFormatter
                    .parse(json.asString)
                    .time
            },
        ).create()
