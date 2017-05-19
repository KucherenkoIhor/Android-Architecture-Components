package com.ik.exploringviewmodel.flow.repos

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.ik.exploringviewmodel.base.BaseViewModel
import com.ik.exploringviewmodel.sources.repos.ReposRepository
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.LiveData
import com.ik.exploringviewmodel.entities.Repo
import android.arch.lifecycle.*




/**
 * Created by ihor on 19.05.17.
 */
class ReposViewModel(application: Application?) : BaseViewModel(application) {

    private val reposRepository = ReposRepository()

    private val organizationLiveData = MutableLiveData<String>()

    val repositories: LiveData<List<Repo>> = Transformations.switchMap(organizationLiveData) {
       // reposRepository.getRepositories(it)
    }

    fun setOrganization(organization: String) {
        organizationLiveData.value = organization

       // LiveDataReactiveStreams

    }

//
//    fun getRepositories(organization: String) = reposRepository
//            .getRepositories(organization)
//            .doOnSubscribe { bindToLifecycle(it) }
}