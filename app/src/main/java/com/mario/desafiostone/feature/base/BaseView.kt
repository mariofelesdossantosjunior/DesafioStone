package com.mario.desafiostone.feature.base

import android.content.Context

/**
 * Created by mario on 9/28/17.
 */
interface BaseView {

    fun getContext(): Context

    fun showError(erro: String)

}