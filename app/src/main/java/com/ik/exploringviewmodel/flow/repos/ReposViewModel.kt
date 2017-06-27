package com.ik.exploringviewmodel.flow.repos

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.repos.ReposRepository




/**
 * Created by ihor on 19.05.17.
 */
class ReposViewModel(application: Application?) : AndroidViewModel(application) {

    private val organizationLiveData = MutableLiveData<String>()

    val resultLiveData = ReposLiveData()
    init {
        resultLiveData.addSource(organizationLiveData) {
            it?.let { resultLiveData.organization = it }
        }
    }

    val isLoadingLiveData = MediatorLiveData<Boolean>()
    init {
        isLoadingLiveData.addSource(resultLiveData) {
            isLoadingLiveData.value = false
        }
    }

    val throwableLiveData = MediatorLiveData<Throwable>()
    init {
        throwableLiveData.addSource(resultLiveData) {
            it?.second?.let { throwableLiveData.value = it }
        }
    }

    val reposLiveData = MediatorLiveData<List<Repo>>()
    init {
        reposLiveData.addSource(resultLiveData) {
                it?.first?.let { reposLiveData.value = it }
        }
    }

    fun setOrganization(organization: String) {
        organizationLiveData.value = organization
        isLoadingLiveData.value = true
    }

}