package com.ik.exploringviewmodel

/**
 * Created by Minsuk on 2017-07-07.
 */

/**
 * A thread unsafe lazy function.
 * This function 'must' be called only on single thread.
 */
fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)
