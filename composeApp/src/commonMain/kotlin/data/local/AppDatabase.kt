package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import data.local.entity.LocalProduct

@Database(entities = [LocalProduct::class], version = 1)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): AppDao
}