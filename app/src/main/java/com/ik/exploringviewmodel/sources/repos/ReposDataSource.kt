package com.ik.exploringviewmodel.sources.repos

import com.ik.exploringviewmodel.entities.Repo
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by ihor on 18.05.17.
 */
interface ReposDataSource {

    fun getRepositories(organization: String): Single<List<Repo>>

    fun saveRepositories(list: List<Repo>) : Unit = Unit

}