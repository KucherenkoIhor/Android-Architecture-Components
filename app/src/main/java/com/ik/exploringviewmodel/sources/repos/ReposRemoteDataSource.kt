package com.ik.exploringviewmodel.sources.repos


import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.rx.rx_object
import com.ik.exploringviewmodel.entities.Repo
import io.reactivex.Single

/**
 * Created by ihor on 18.05.17.
 */
class ReposRemoteDataSource : ReposDataSource {

    override fun getRepositories(organization: String): Single<List<Repo>> =
            "https://api.github.com/orgs/$organization/repos"
                    .httpGet()
                    .rx_object(Repo.ListDeserializer())
                    .map { t ->
                        t?.component2()?.let { throw it }
                        t?.component1()
                    }

}