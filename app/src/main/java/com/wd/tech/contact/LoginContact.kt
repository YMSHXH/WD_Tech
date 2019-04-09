package com.wd.tech.contact

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wd.tech.bean.LoginBean

/**
 * FileName: LoginContact
 * Author: 杨明森
 * Date: 2019/4/9 18:51
 */
interface LoginContact {
    /**
     * 登录View
     */
    interface ILoginView {
        fun onSuccessLogin(loginBean: LoginBean)
        fun onFailLogin(string: String)
    }

    /**
     * 登录Model
     */
    interface ILoginModle {
        fun toLogin(context: Context,prams:HashMap<String,String>,iModelCallback: IModelCallback<LoginBean>)
    }

    interface ILoginPresenter{
        fun toLogin(context: Context,prams:HashMap<String,String>)
    }
}