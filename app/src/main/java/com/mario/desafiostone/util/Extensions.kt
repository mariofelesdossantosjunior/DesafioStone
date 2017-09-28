package com.mario.desafiostone.util

import android.app.FragmentManager
import android.app.FragmentTransaction

/**
 * Created by mario on 9/27/17.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

