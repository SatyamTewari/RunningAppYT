package com.example.runningappyt.di

import android.content.Context
import androidx.room.Room
import com.example.runningappyt.db.RunningDatabase
import com.example.runningappyt.other.Constants.RUNNING_DATABASE_NAME
import dagger.Component
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Component
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()
}