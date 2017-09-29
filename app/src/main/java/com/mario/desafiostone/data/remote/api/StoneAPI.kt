package com.mario.desafiostone.data.remote.api

import com.mario.desafiostone.data.remote.Product
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable

/**
 * Created by mario on 9/28/17.
 */
interface StoneAPI {
    @GET("products.json")
    fun listProducts(): Observable<MutableList<Product>>


    companion object {
        val BASE_URL_STONE = "https://raw.githubusercontent.com/stone-pagamentos/desafio-mobile/master/"

        fun create(): StoneAPI{

            val retrofit  = Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL_STONE)
                    .build()

            return retrofit.create(StoneAPI::class.java)
        }
    }
}