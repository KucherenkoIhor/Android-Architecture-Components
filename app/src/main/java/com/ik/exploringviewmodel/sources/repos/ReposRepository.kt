package com.ik.exploringviewmodel.sources.repos

import android.content.Context
import android.util.Log
import com.google.gson.Gson
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

    override fun getRepositories(organization: String): Single<List<Repo>> {
//        return localDataSource
//                .getRepositories(organization)
//                .onErrorResumeNext {
                  return  remoteDataSource.getRepositories(organization)
                            .doOnSuccess { Log.d("TAGGG", Gson().toJson(it)) }
                            .doOnSuccess {
                                localDataSource.saveRepos(it?.toMutableList() ?: return@doOnSuccess)
                            } //}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}