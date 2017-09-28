package com.mario.desafiostone.data.remote.api

import com.mario.desafiostone.data.remote.Product
import com.mario.desafiostone.util.Constants
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
    fun listProducts(): Observable<List<Product>>


    companion object {
        fun create(): StoneAPI{
            val retrofit  = Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL_STONE)
                    .build()

            return retrofit.create(StoneAPI::class.java)
        }
    }
}