package com.mario.desafiostone.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by mario on 9/27/17.
 */
class Generics {
    @SuppressLint("MissingPermission")
    private fun  isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}