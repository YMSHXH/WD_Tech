package com.kotlinframework.net.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * FileName: HeaderInterceptor 头部拦截器
 * Author: 杨明森
 * Date: 2019/4/9 19:23
 */
class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()//原始请求对象
        val nrequest = originalRequest.newBuilder()
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("ak", "0110010010000")
            .build()

        return chain.proceed(nrequest)

    }
}