package com.ik.exploringviewmodel.flow.repos

import android.arch.lifecycle.MediatorLiveData
import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.repos.ReposRepository
import io.reactivex.disposables.Disposable

/**
 * Created by ihor on 21.05.17.
 */

class ReposLiveData(val repository: ReposRepository)
    : MediatorLiveData<Pair<List<Repo>?, Throwable?>>() {

    private var disposable: Disposable? = null

    var organization: String? = null
        set(value) {
            value?.let {
                disposable = repository
                        .getRepositories(it)
                        .subscribe { data, error -> this@ReposLiveData.value = Pair(data, error)}

            }
        }

    override fun onInactive() {
        super.onInactive()
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }

}