package com.mario.desafiostone.feature.base

/**
 * Created by mario on 9/28/17.
 */
open class BasePresenterImpl<V : BaseView> : BasePresenter<V>{

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

}