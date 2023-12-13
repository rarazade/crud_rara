package com.example.crud_room.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class note(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val note : String
)

