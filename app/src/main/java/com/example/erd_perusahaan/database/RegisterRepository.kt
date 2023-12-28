package com.example.erd_perusahaan.database

class RegisterRepository(private val dao:RegisterDatabaseDao) {
    val users= dao.getALlUsers()

    suspend fun insert(user:RegisterEntity){
        return dao.insert(user)
    }
    suspend fun getUsername(userName:String):RegisterEntity?{
        return dao.getUsername(userName)
    }
}