package com.mario.desafiostone.feature.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by mario on 9/28/17.
 */
abstract class BaseActivity<in V : BaseView, T : BasePresenter<V>> : AppCompatActivity(),BaseView {

    protected abstract var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as  V)
    }

    override fun getContext(): Context = this

    override fun showError(erro: String) = Toast.makeText(this,erro,Toast.LENGTH_LONG).show()

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}