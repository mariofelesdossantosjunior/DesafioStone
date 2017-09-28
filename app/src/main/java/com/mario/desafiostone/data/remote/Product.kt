package com.mario.desafiostone.data.remote

import com.google.gson.annotations.SerializedName

/**
 * Created by mario on 9/28/17.
 */

data class Product(@SerializedName("title") val title: String,
                   @SerializedName("price") val price: Int,
                   @SerializedName("zipcode") val zipcode: String,
                   @SerializedName("seller") val seller: String,
                   @SerializedName("thumbnailHd") val thumbnailHd: String,
                   @SerializedName("date") val date: String)