package com.wd.tech.api

import com.wd.tech.bean.LoginBean
import com.wd.tech.bean.RegisterBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * FileName: UserService
 * Author: 杨明森
 * Date: 2019/4/9 18:41
 */
interface UserService {

    /**
     * 登录
     */
    @POST(Apis.LOGIN_URL)
    @FormUrlEncoded
    fun toLogin(@FieldMap prams:HashMap<String,String>) : Observable<LoginBean>

    /**
     * 登录
     */
    @POST(Apis.REGISTRY_URL)
    @FormUrlEncoded
    fun toRigister(@FieldMap prams:HashMap<String,String>) : Observable<RegisterBean>
}