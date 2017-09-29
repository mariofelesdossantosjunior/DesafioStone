package com.mario.desafiostone.util

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by mario on 9/27/17.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

