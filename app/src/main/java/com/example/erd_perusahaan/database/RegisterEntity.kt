package com.example.erd_perusahaan.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Register_users_table")
data class RegisterEntity(
    @PrimaryKey(autoGenerate = true)
    var userId:Int=0,

    @ColumnInfo(name="username")
    var username:String,

    @ColumnInfo(name="email")
    var email:String,

    @ColumnInfo(name="password")
    var password:String
)
