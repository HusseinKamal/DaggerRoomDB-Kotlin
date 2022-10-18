package com.hussein.daggerroomdb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    //Database keywords for any query is not case sensitive
    @Query("SELECT * FROM user_entity ORDER BY id DESC")
    fun getAllRecordsFromDB():List<UserEntity>

    @Insert
    fun insertRecord(userEntity: UserEntity)
}