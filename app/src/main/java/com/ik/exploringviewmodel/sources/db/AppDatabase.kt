package com.ik.exploringviewmodel.sources.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.db.dao.ReposDao

@Database(entities = arrayOf(Repo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun reposDao(): ReposDao

    companion object {

        internal val DATABASE_NAME = "basic-sample-db"
    }

}