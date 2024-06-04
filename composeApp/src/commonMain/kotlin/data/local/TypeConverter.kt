package data.local

import androidx.room.TypeConverter
import data.local.entity.LocalRating
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class TypeConverter {
    @TypeConverter
    fun fromLocalRating(localRating: LocalRating?): String? {
        return localRating?.let { Json.encodeToString(it) }
    }

    @TypeConverter
    fun toLocalRating(json: String?): LocalRating? {
        return json?.let { Json.decodeFromString(it) }
    }
}