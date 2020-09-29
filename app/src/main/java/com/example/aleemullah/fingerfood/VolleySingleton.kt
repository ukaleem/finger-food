package com.example.aleemullah.fingerfood

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
/*
|---------------------------------------------
|
* This is the main volley Singleton Class that is uesd for
* -Connectivity with database , this is the second way of connectivity
* -Hard Code class is better practise for conection.
* -That is Copy past volleySingleton Code By the Volley Develpores
*
|----------------------------------------------
* */

class VolleySingleton : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(applicationContext)
            }
            return field
        }

    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        requestQueue?.add(request)
    }

    companion object {
        private val TAG = VolleySingleton::class.java.simpleName
        @get:Synchronized var instance: VolleySingleton? = null
            private set
    }
}