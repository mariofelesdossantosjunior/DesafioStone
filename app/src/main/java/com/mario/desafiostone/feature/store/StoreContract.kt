package com.mario.desafiostone.feature.store

import com.mario.desafiostone.data.remote.Product
import com.mario.desafiostone.feature.base.BasePresenter
import com.mario.desafiostone.feature.base.BaseView

/**
 * Created by mario on 9/28/17.
 */
object StoreContract {

    interface View : BaseView{
        fun showProducts(products: MutableList<Product>)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter : BasePresenter<View>{
        fun loadProducts()
    }
}