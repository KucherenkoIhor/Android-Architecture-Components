package com.ik.exploringviewmodel.sources.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ik.exploringviewmodel.entities.Repo
import io.reactivex.Completable
import io.reactivex.Flowable


/**
 * Created by ihor on 18.05.17.
 */
@Dao
interface ReposDao {

    @Query("SELECT * FROM repos")
    fun loadAllRepos(): Flowable<List<Repo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: MutableList<Repo>) : Unit

//    @Query("select * from repos where id = id")
//    fun loadRepo(id: Int): Flowable<Repo>
//
//    @Query("select * from repos where id = id")
//    fun loadRepoSync(id: Int): Repo
}