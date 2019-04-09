package com.wd.tech.presenter

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wd.tech.bean.RegisterBean
import com.wd.tech.contact.RigisterContact
import com.wd.tech.model.RigisterModle

/**
 * FileName: RigisterPresenter
 * Author: 杨明森
 * Date: 2019/4/9 20:30
 */
class RigisterPresenter : RigisterContact.IRigisterPresenter {

    var iRigisterView : RigisterContact.IRigisterView
    var rigisterModle : RigisterModle

    constructor(iRigisterView : RigisterContact.IRigisterView){
        this.iRigisterView = iRigisterView
        rigisterModle = RigisterModle()
    }

    override fun toRigister(context: Context, prams: HashMap<String, String>) {
        rigisterModle.toRigister(context,prams,object : IModelCallback<RegisterBean>{
            override fun sucess(data: RegisterBean) {
                iRigisterView.onSuccessRigister(data)
            }

            override fun failure(string: String) {
                iRigisterView.onFailRigister(string)
            }

        })
    }
}