package com.mario.desafiostone.util

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.text.DecimalFormat

/**
 * Created by mario on 9/27/17.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

fun Int.intFormat(): String {
    return "R$ " + DecimalFormat("###,##0.00").format(this / 100)
}

fun ImageView.loadUrl(url: String) {
    this.setImageURI(Uri.parse(url))
}

