package com.ik.exploringviewmodel.flow.repos

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import com.ik.exploringviewmodel.R
import com.ik.exploringviewmodel.base.BaseLifecycleActivity

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
        updateUI()
        vRefresh.setOnRefreshListener(this)
    }

    private fun updateUI() {
        viewModel.getRepositories("yalantis")
                .doAfterTerminate { vRefresh.isRefreshing = false }
                .subscribe { data, error ->
                    error?.printStackTrace()
                    data?.let { adapter.dataSource = it }  }
    }

    override fun onRefresh() {
        updateUI()
    }
}
