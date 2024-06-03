package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import data.local.entity.LocalProduct

@Database(entities = [LocalProduct::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): AppDao
}