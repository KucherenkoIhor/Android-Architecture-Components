package com.ik.exploringviewmodel.sources.repos

import android.util.Log
import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.db.DatabaseCreator
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by ihor on 18.05.17.
 */
class ReposLocalDataSource : ReposDataSource {

    val reposDao = DatabaseCreator.database.reposDao()

    override fun getRepositories(organization: String): Single<List<Repo>>
        = reposDao
            .loadAllRepos()
            .firstOrError()

    override fun saveRepositories(list: List<Repo>)
        =  reposDao.insertAll(list.toMutableList())

}