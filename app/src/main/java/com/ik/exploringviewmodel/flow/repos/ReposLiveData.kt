package com.ik.exploringviewmodel.flow.repos

import android.arch.lifecycle.LiveData
import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.repos.ReposRepository
import io.reactivex.disposables.Disposable

/**
 * Created by ihor on 21.05.17.
 */

class ReposLiveData(repository: ReposRepository, organization: String)
    : LiveData<Pair<List<Repo>?, Throwable?>>() {

    private var disposable: Disposable? = null

    init {
        disposable = repository
                .getRepositories(organization)
                .subscribe { data, error -> value = Pair(data, error)}
    }

    override fun onInactive() {
        super.onInactive()
        if(disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }

}
