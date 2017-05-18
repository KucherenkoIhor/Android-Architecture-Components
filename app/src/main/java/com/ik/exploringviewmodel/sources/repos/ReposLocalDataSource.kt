package com.ik.exploringviewmodel.sources.repos

import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.base.BaseLocalDataSource
import com.ik.exploringviewmodel.sources.db.DatabaseCreator
import io.reactivex.Single

/**
 * Created by ihor on 18.05.17.
 */
class ReposLocalDataSource : BaseLocalDataSource(), ReposDataSource {

    override fun getRepositories(organization: String): Single<List<Repo>>?
        = DatabaseCreator.database?.reposDao()?.loadAllRepos()?.singleOrError()

}