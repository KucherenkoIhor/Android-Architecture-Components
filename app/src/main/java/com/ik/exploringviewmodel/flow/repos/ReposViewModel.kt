package com.ik.exploringviewmodel.flow.repos

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.ik.exploringviewmodel.base.BaseViewModel
import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.repos.ReposRepository




/**
 * Created by ihor on 19.05.17.
 */
class ReposViewModel(application: Application?) : BaseViewModel(application) {

    private val reposRepository = ReposRepository()

    private val organizationLiveData = MutableLiveData<String>()

    val isLoadingLiveData = MutableLiveData<Boolean>()

    val throwableLiveData = MutableLiveData<Throwable>()

    val listRepoLiveData = MutableLiveData<List<Repo>>()

    init {
      organizationLiveData.observeForever {
          reposRepository
                  .getRepositories(it ?: return@observeForever)
                  .doOnSubscribe { isLoadingLiveData.value = true }
                  .doAfterTerminate { isLoadingLiveData.value = false}
                  .doOnSubscribe { bindToLifecycle(it) }
                  .subscribe { data, error ->
                      error?.let { throwableLiveData.value = it }
                      data?.let { listRepoLiveData.value = it }  }
      }
    }


    fun setOrganization(organization: String) {
        organizationLiveData.value = organization
    }

    override fun onCleared() {

        super.onCleared()
    }
}