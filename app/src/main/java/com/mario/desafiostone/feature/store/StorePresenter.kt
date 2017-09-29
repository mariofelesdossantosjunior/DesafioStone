package com.mario.desafiostone.feature.store

import com.mario.desafiostone.data.remote.api.StoneAPI
import com.mario.desafiostone.feature.base.BasePresenterImpl
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by mario on 9/28/17.
 */
class StorePresenter: BasePresenterImpl<StoreContract.View>(), StoreContract.Presenter {

    val compositeSubscription: CompositeSubscription = CompositeSubscription()

    val stoneService by lazy {
        StoneAPI.create()
    }

    override fun loadProducts() {
        compositeSubscription.add(
                stoneService.listProducts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ mView?.showProducts(it)},
                                   {erro -> mView?.showError(erro.message!!)})
        )
    }

    override fun detachView() {
        compositeSubscription.clear()
        super.detachView()
    }
}