package com.ik.exploringviewmodel.base

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by ihor on 19.05.17.
 */
@Suppress("LeakingThis")
abstract class BaseLifecycleActivity<T : AndroidViewModel> : AppCompatActivity(), LifecycleRegistryOwner {

    abstract val viewModelClass: Class<T>

    protected lateinit var viewModel: T

    private val registry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry = registry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
    }
}
