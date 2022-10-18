package com.hussein.daggerroomdb.di

import android.app.Application
import android.content.Context
import com.hussein.daggerroomdb.database.AppDatabase
import com.hussein.daggerroomdb.database.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase):UserDao{
        return appDatabase.getUserDao()
    }

    @Singleton
    @Provides
    fun getRoomDBInstance():AppDatabase{
        return AppDatabase.getDatabaseInstance(provideAppContext())
    }

    @Singleton
    @Provides
    fun provideAppContext():Context{
        return application.applicationContext
    }
}