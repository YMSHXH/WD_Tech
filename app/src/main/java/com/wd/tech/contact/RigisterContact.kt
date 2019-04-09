package com.wd.tech.contact

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wd.tech.bean.RegisterBean

/**
 * FileName: RigisterContact
 * Author: 杨明森
 * Date: 2019/4/9 20:26
 */
interface RigisterContact {
    /**
     * 注册View
     */
    interface IRigisterView {
        fun onSuccessRigister(rigisterBean: RegisterBean)
        fun onFailRigister(string: String)
    }

    /**
     * 注册Model
     */
    interface IRigisterModle {
        fun toRigister(context: Context, prams:HashMap<String,String>, iModelCallback: IModelCallback<RegisterBean>)
    }

    /**
     * 注册
     */
    interface IRigisterPresenter{
        fun toRigister(context: Context,prams:HashMap<String,String>)
    }
}