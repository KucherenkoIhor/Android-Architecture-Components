package com.ik.exploringviewmodel

import android.support.test.runner.AndroidJUnit4
import com.ik.exploringviewmodel.sources.repos.ReposLocalDataSource
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception

/**
 * Created by ihor_kucherenko on 6/27/17.
 * https://github.com/KucherenkoIhor
 */
@RunWith(AndroidJUnit4::class)
class SampleInstrumentedTest {

    @Test
    fun localDataStoreEmpty() {
        ReposLocalDataSource
                .getRepositories("non-existent")
                .test()
                .assertEmpty()
    }

//    @Test
//    fun localDataStoreNonEmpty() {
//        ReposLocalDataSource.saveRepositories()
//        ReposLocalDataSource
//                .getRepositories("non-existent")
//                .test()
//                .assertEmpty()
//    }

}