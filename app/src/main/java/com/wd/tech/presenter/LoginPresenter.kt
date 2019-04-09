package com.wd.tech.presenter

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wd.tech.bean.LoginBean
import com.wd.tech.contact.LoginContact
import com.wd.tech.model.LoginModle

/**
 * FileName: LoginPresenter
 * Author: 杨明森
 * Date: 2019/4/9 18:59
 */
class LoginPresenter : LoginContact.ILoginPresenter {

    var iLoginView : LoginContact.ILoginView
    var loginModle : LoginModle

    constructor(iLoginView : LoginContact.ILoginView){
        this.iLoginView = iLoginView
        loginModle = LoginModle()
    }

    override fun toLogin(context: Context, prams: HashMap<String, String>) {
        loginModle.toLogin(context,prams,object : IModelCallback<LoginBean>{
            override fun sucess(data: LoginBean) {
                iLoginView.onSuccessLogin(data)
            }

            override fun failure(string: String) {
                iLoginView.onFailLogin(string)
            }

        })
    }
}