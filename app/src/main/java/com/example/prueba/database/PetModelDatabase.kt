package com.example.prueba.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.prueba.model.PetModel


@Database(
    entities = [PetModel::class],
    version = 1
)
abstract class PetModelDatabase : RoomDatabase(){

    abstract fun PetModelDao() : PetModelDao

    companion object {
        @Volatile
        private var INSTANCE: PetModelDatabase? = null

        fun getDatabase(context: Context): PetModelDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PetModelDatabase::class.java,
                    "pet_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
