package com.wd.tech.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.kotlinframework.net.network.RetrofitManager
import com.wd.tech.api.Apis

/**
 * FileName: MyApp
 * Author: 杨明森
 * Date: 2019/4/8 15:40
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitManager.instance.init(Apis.BASE_URL)
        Fresco.initialize(this)
    }
}