package com.ik.exploringviewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.ik.exploringviewmodel.entities.Repo
import com.ik.exploringviewmodel.sources.db.DatabaseCreator
import com.ik.exploringviewmodel.sources.repos.ReposLocalDataSource
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception
import android.support.test.rule.ActivityTestRule
import com.ik.exploringviewmodel.flow.repos.ReposActivity
import com.ik.exploringviewmodel.flow.repos.ReposViewModel
import org.junit.Rule
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.junit.Assert.*
import org.junit.runner.Result


/**
 * Created by ihor_kucherenko on 6/27/17.
 * https://github.com/KucherenkoIhor
 */
@RunWith(AndroidJUnit4::class)
class SampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule<ReposActivity>(ReposActivity::class.java, true, true)

    private var viewModel: ReposViewModel? = null

    @Before
    fun init() {
        viewModel = ViewModelProviders.of(activityRule.activity).get(ReposViewModel::class.java)
    }

    @Test
    fun testNotNull() {
        activityRule.activity.runOnUiThread {
            viewModel?.setOrganization("yalantis")
            viewModel?.reposLiveData?.observe(activityRule.activity, Observer<List<Repo>> {
               assertNotNull(it)
            })
        }
    }
}