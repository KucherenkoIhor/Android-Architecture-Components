package com.ik.exploringviewmodel.flow.repos

import android.arch.lifecycle.LiveData
import com.ik.exploringviewmodel.entities.Repo
import io.reactivex.disposables.Disposable

/**
 * Created by ihor on 19.05.17.
 */
class ReposLiveData : LiveData<Repo>() {

    private val disposabe: Disposable? = null

    override fun onActive() {
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }

    override fun setValue(value: Repo?) {
        super.setValue(value)
    }


}