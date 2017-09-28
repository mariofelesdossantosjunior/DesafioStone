package com.mario.desafiostone.feature.store

/**
 * Created by mario on 9/27/17.
 */
interface StorePresenter {
    fun loadProducts(products: MutableList<String>)
    fun onDestroy()
}