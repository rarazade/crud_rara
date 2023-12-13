package com.example.crud_room.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface noteDao {
    @Insert
    suspend fun  addNote (note: note)
    @Update
    suspend fun updateNote (note: note)
    @Delete
    suspend fun deleteNote (note: note)
    @Query("SELECT * FROM note")
    suspend fun getNote () : List<note>
    @Query ("SELECT * FROM note WHERE id=:note_id")
    suspend fun getNote (note_id: Int): List<note>
}