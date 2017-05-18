package com.ik.exploringviewmodel.flow.repos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ik.exploringviewmodel.R
import com.ik.exploringviewmodel.sources.repos.ReposRepository


class ReposActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)
        val rep = ReposRepository()
        rep.init(this)
        rep.getRepositories("yalantis")?.subscribe { t1, t2 -> t2.printStackTrace() }
    }
}
