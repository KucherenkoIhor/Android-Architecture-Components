package com.ik.exploringviewmodel.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by ihor on 18.05.17.
 */
@Entity(tableName = "repos")
data class Repo (
        @PrimaryKey var id: Long?,
        var name: String?,
        var full_name: String?,
        var description: String?,
        var organization: String?)