package com.ik.exploringviewmodel

import android.app.Application
import com.ik.exploringviewmodel.sources.db.DatabaseCreator

/**
 * Created by ihor on 19.05.17.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseCreator.createDb(this)
    }
}