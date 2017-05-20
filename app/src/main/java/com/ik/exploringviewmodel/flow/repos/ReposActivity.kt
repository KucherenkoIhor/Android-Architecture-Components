package com.ik.exploringviewmodel.flow.repos

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
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

        updateUI()
    }

    private fun updateUI() {

        viewModel.isLoadingLiveData.observe(this, Observer<Boolean> {
            it?.let { vRefresh.isRefreshing = it }
        })

        viewModel.listRepoLiveData.observe(this, Observer<List<Repo>> {
           Log.d("TAGGG", "fddfdf" + it)
            it?.let { adapter.dataSource = it }
        })

        viewModel.throwableLiveData.observe(this, Observer<Throwable> {
            Log.d("TAGGG", "fddfdfffffffffffffffffff")
        })
    }

    override fun onRefresh() {
        viewModel.setOrganization("yalantis")
    }
}
