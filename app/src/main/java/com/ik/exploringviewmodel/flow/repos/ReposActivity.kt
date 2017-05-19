package com.ik.exploringviewmodel.flow.repos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.ik.exploringviewmodel.R
import com.ik.exploringviewmodel.sources.db.DatabaseCreator
import com.ik.exploringviewmodel.sources.repos.ReposRepository


class ReposActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)
        val rep = ReposRepository()
        rep.getRepositories("yalantis")
                .doOnSuccess { Log.d("TAGGGG", "" + Gson().toJson(it)) }
                .subscribe { t1, t2 -> t2?.printStackTrace() }
    }
}
