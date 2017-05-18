package com.ik.exploringviewmodel.sources.db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Room
import android.content.Context
import android.util.Log
import com.ik.exploringviewmodel.sources.db.AppDatabase.DATABASE_NAME
import io.reactivex.Completable
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Creates the [AppDatabase] asynchronously, exposing a LiveData object to notify of creation.
 */
object DatabaseCreator {

    private val mIsDatabaseCreated = MutableLiveData<Boolean>()

    var database: AppDatabase? = null
        private set

    private val mInitializing = AtomicBoolean(true)

    /** Used to observe when the database initialization is done  */
    val isDatabaseCreated: LiveData<Boolean>
        get() = mIsDatabaseCreated

    /**
     * Creates or returns a previously-created database.
     *
     */
    fun createDb(context: Context) {

        Log.d("DatabaseCreator", "Creating DB from " + Thread.currentThread().name)

        if (mInitializing.compareAndSet(true, false).not()) {
            return  // Already initializing
        }
        mIsDatabaseCreated.value = false// Trigger an update to show a loading screen.

        Completable.fromAction {
            Log.d("DatabaseCreator",
                    "Starting bg job " + Thread.currentThread().name)

            // Reset the database to have new data on every run.
            context.deleteDatabase(DATABASE_NAME)

            // Build the database!
            val db = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
            database = db
        }.subscribe { mIsDatabaseCreated.value = true }
    }

}