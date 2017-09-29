package com.mario.desafiostone

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by mario on 9/29/17.
 */
class App: Application(){

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}