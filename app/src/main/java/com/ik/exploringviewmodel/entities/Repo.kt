package com.ik.exploringviewmodel.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by ihor on 18.05.17.
 */
@Entity(tableName = "repos")
class Repo(@PrimaryKey var id: Long? = null,
           var name: String? = null,
           var full_name: String? = null,
           var description: String? = null) {

    class Deserializer : ResponseDeserializable<Repo> {
        override fun deserialize(content: String) = Gson().fromJson(content, Repo::class.java)
    }

    class ListDeserializer : ResponseDeserializable<List<Repo>> {
        override fun deserialize(content: String) = Gson()
                .fromJson<List<Repo>>(content, object : TypeToken<List<Repo>>() {}.type)
    }

}