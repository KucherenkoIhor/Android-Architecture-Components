package com.ik.exploringviewmodel.sources.repos

import com.ik.exploringviewmodel.entities.Repo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by ihor on 18.05.17.
 */
object ReposRepository : ReposDataSource {

    override fun getRepositories(organization: String): Single<List<Repo>>
        = ReposLocalDataSource
                .getRepositories(organization)
                .onErrorResumeNext {
                    ReposRemoteDataSource.getRepositories(organization)
                            .doOnSuccess { ReposLocalDataSource.saveRepositories(it) }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
}