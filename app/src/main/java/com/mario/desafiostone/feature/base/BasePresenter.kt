package com.mario.desafiostone.feature.base

/**
 * Created by mario on 9/28/17.
 */
interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}