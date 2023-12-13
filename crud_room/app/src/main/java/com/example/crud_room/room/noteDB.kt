package com.example.crud_room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database (
    entities = [note::class],
    version = 1
)

abstract class noteDB : RoomDatabase(){
    abstract fun noteDao() : noteDao

    companion object{
        @Volatile private var instance: noteDB? = null
        private val Lock = Any()

        operator fun invoke (context: Context) = instance ?: synchronized(Lock){
            instance ?: buildDatabase(context).also{
                instance = it
            }
        }

        private fun buildDatabase(context: Context)=Room.databaseBuilder(
            context.applicationContext,
            noteDB::class.java,
            "note12345.db"
        ).build()
    }
}