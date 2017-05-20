package com.ik.exploringviewmodel.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by ihor on 19.05.17.
 */
open class BaseViewModel(application: Application?) : AndroidViewModel(application) {

    private var disposables : CompositeDisposable = CompositeDisposable()

    protected fun bindToLifecycle(disposable: Disposable) {
        if(disposables.isDisposed) {
            disposables = CompositeDisposable()
        }
        disposables.add(disposable)
    }

    override fun onCleared() {
        if(disposables.isDisposed.not()) {
            disposables.clear()
        }
        super.onCleared()
    }
}