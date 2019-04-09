package com.wd.tech.model

import android.content.Context
import com.kotlinframework.net.network.*
import com.wd.tech.api.UserService
import com.wd.tech.bean.LoginBean
import com.wd.tech.contact.LoginContact

/**
 * FileName: LoginModle
 * Author: 杨明森
 * Date: 2019/4/9 18:55
 */
class LoginModle : LoginContact.ILoginModle {
    /**
     * 登录
     */
    override fun toLogin(context: Context, prams: HashMap<String, String>, iModelCallback: IModelCallback<LoginBean>) {
        RetrofitManager.instance.createService(UserService::class.java)
            .toLogin(prams)
            .compose(NetScheduler.compose())
            .subscribe(object : NetResponseObserver<LoginBean>(context){
                override fun success(data: LoginBean) {
                    if ("0000" == data.status){
                        iModelCallback.sucess(data)
                    } else{
                        iModelCallback.failure(data.message)
                    }
                }

                override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                    iModelCallback.failure("网络错误$statusCode")
                }

            })
    }
}