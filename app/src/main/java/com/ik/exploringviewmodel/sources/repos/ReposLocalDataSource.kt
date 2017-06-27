package com.ik.exploringviewmodel.sources.repos

import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.db.DatabaseCreator
import io.reactivex.Single

/**
 * Created by ihor on 18.05.17.
 */
object ReposLocalDataSource : ReposDataSource {

    val reposDao = DatabaseCreator.database.reposDao()

    override fun getRepositories(organization: String): Single<List<Repo>>
        = reposDao
                .loadAllRepos(organization)
                .firstOrError()
                .doOnSuccess { if (it.isEmpty()) throw Exception() }


    override fun saveRepositories(list: List<Repo>)
        =  reposDao.insertAll(list.toMutableList())

}