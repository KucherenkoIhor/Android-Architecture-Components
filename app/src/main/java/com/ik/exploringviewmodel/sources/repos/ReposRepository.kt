package com.ik.exploringviewmodel.sources.repos

import android.content.Context
import com.ik.exploringviewmodel.entities.Repo
import io.reactivex.Single

/**
 * Created by ihor on 18.05.17.
 */
class ReposRepository : ReposDataSource {

    private val localDataSource = ReposLocalDataSource()
    private val remoteDataSource = ReposRemoteDataSource()

    override fun init(context: Context) {
        super.init(context)
        localDataSource.init(context)
    }

    override fun getRepositories(organization: String): Single<List<Repo>>? {
        return localDataSource.getRepositories(organization) ?: remoteDataSource.getRepositories(organization)
    }
}