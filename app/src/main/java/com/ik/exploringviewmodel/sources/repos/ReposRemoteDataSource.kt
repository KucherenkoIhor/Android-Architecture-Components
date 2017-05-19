package com.ik.exploringviewmodel.sources.repos


import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.rx.rx_object
import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.log
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ihor on 18.05.17.
 */
class ReposRemoteDataSource : ReposDataSource {

    override fun getRepositories(organization: String): Single<List<Repo>> =
            "https://api.github.com/orgs/$organization/repos"
                    .httpGet()
                    .log()
                    .rx_object(Repo.ListDeserializer())
                    .map { it?.component1() ?: throw it?.component2() ?: throw Exception() }

}