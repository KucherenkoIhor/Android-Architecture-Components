package com.ik.exploringviewmodel.sources.repos

import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.base.BaseDataSource
import io.reactivex.Single

/**
 * Created by ihor on 18.05.17.
 */
interface ReposDataSource : BaseDataSource {

    fun getRepositories(organization: String): Single<List<Repo>>?
}