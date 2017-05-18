package com.ik.exploringviewmodel.sources.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.ik.exploringviewmodel.entities.Repo;
import com.ik.exploringviewmodel.sources.db.dao.ReposDao;

@Database(entities = {Repo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "basic-sample-db";

    public abstract ReposDao reposDao();

}