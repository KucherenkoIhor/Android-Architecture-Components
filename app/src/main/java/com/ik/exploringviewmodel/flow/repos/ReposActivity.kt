package com.ik.exploringviewmodel.flow.repos

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import com.ik.exploringviewmodel.R
import com.ik.exploringviewmodel.base.BaseLifecycleActivity
import com.ik.exploringviewmodel.entities.Repo

class ReposActivity : BaseLifecycleActivity<ReposViewModel>(), SwipeRefreshLayout.OnRefreshListener {

    override val viewModelClass = ReposViewModel::class.java

    private val rv by lazy { findViewById(R.id.rv) as RecyclerView }

    private val vRefresh by lazy { findViewById(R.id.lRefresh) as SwipeRefreshLayout }

    private val adapter = ReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)
        rv.setHasFixedSize(true)
        rv.adapter = adapter
        vRefresh.setOnRefreshListener(this)

        if (savedInstanceState == null) {
            viewModel.setOrganization("yalantis")
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.isLoadingLiveData.observe(this, Observer<Boolean> {
            it?.let { vRefresh.isRefreshing = it }
        })
        viewModel.reposLiveData.observe(this, Observer<List<Repo>> {
            it?.let { adapter.dataSource = it }
        })
        viewModel.throwableLiveData.observe(this, Observer<Throwable> {
            it?.let { Snackbar.make(rv, it.localizedMessage, Snackbar.LENGTH_LONG).show() }
        })
    }

    override fun onRefresh() {
        viewModel.setOrganization("yalantis")
    }
}
