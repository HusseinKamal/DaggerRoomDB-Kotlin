package com.hussein.daggerroomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hussein.daggerroomdb.MyApp
import com.hussein.daggerroomdb.database.UserDao
import com.hussein.daggerroomdb.database.UserEntity
import javax.inject.Inject

class MainViewModel(application: Application):AndroidViewModel(application) {

    @Inject
    lateinit var userDao: UserDao
    var allUsersList:MutableLiveData<List<UserEntity>> = MutableLiveData()


    init {
        (application as MyApp).getAppComponent().inject(this)
        getAllRecords()
    }

    fun getRecordsObservers():MutableLiveData<List<UserEntity>>{
        return allUsersList
    }

    fun getAllRecords(){
        val list=userDao.getAllRecordsFromDB()
        allUsersList.postValue(list)
    }

    fun insertRecord(userEntity: UserEntity)
    {
        getAllRecords()
        userDao.insertRecord(userEntity)
    }
}