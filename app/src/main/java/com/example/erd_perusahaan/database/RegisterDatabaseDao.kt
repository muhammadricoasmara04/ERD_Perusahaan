package com.example.erd_perusahaan.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query

interface RegisterDatabaseDao {
    @Insert
    suspend fun insert(register:RegisterEntity)

    @Query("SELECT * FROM Register_users_table ORDER BY userId DESC")
    fun getALlUsers():LiveData<List<RegisterEntity>>

    @Query("SELECT * FROM Register_users_table WHERE username LIKE :username")
    suspend fun getUsername(username:String):RegisterEntity?
}