package com.ik.exploringviewmodel.sources.repos

import com.ik.exploringviewmodel.entities.Repo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by ihor on 18.05.17.
 */
class ReposRepository : ReposDataSource {

    private val localDataSource = ReposLocalDataSource()
    private val remoteDataSource = ReposRemoteDataSource()

    override fun getRepositories(organization: String): Single<List<Repo>>
        = localDataSource
                .getRepositories(organization)
                .onErrorResumeNext {
                    remoteDataSource.getRepositories(organization)
                            .doOnSuccess { localDataSource.saveRepositories(it) }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
}