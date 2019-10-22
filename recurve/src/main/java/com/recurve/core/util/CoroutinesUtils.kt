package com.recurve.core.util

import kotlinx.coroutines.*

/**
 * 异步任务
 *
 * @method: io
 * @author create by Tang
 * @date 2019-05-16 22:54
 */

fun<R> io(action: () -> R, result: ((R) -> Unit)? = null) = runBlocking{
    GlobalScope.launch(Dispatchers.Main){
        val r = GlobalScope.async(Dispatchers.IO) {
            return@async action()
        }.await()
        result?.invoke(r)
    }
}