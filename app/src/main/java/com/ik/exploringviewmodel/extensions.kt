package com.ik.exploringviewmodel

import android.util.Log
import com.github.kittinunf.fuel.core.Request

/**
 * Created by ihor on 19.05.17.
 */

fun Request.log() : Request {
    response { request, response, result -> Log.d("HTTP", response.toString()) }
    return this
}