package com.ik.exploringviewmodel.sources.base

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.ik.exploringviewmodel.sources.db.DatabaseCreator


/**
 * Created by ihor on 18.05.17.
 */
open class BaseLocalDataSource : BaseDataSource {

    companion object {
        @JvmStatic
        val ABSENT = MutableLiveData<Nothing>()
        init {
            ABSENT.value = null;
        }
    }

    override fun init(context: Context) {
//        Transformations.switchMap(DatabaseCreator.isDatabaseCreated,
//                object : Function<Boolean, LiveData<List<Repo>>> {
//                    override fun apply(isDbCreated: Boolean?): LiveData<List<Repo>> {
//                        if(isDbCreated ?: false) {
//                            return DatabaseCreator.database?.reposDao();
//                        } else {
//
//                        }
//                    }
//                })

        DatabaseCreator.createDb(context)

    }

}