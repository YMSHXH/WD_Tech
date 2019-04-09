package com.wd.tech.presenter

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wd.tech.bean.InforBannerBean
import com.wd.tech.bean.InforListBean
import com.wd.tech.contact.InforContact
import com.wd.tech.model.InforModel

/**
 * FileName: InforPresenter
 * Author: 杨明森
 * Date: 2019/4/8 16:00
 */
class InforPresenter : InforContact.IinforPresenter {


    var iinforView :InforContact.IinforView
    var inforModel : InforModel

    constructor(iinforView :InforContact.IinforView){
        this.iinforView = iinforView
        inforModel = InforModel()
    }

    override fun onBanner(context: Context) {
        inforModel.onBanner(context,object : IModelCallback<InforBannerBean>{
            override fun sucess(data: InforBannerBean) {
                iinforView.onSuccessBanner(data)
            }

            override fun failure(string: String) {
                iinforView.onFailBanner(string)
            }

        })
    }

    /**
     * 请求集合
     */
    override fun onInforList(context: Context, params: HashMap<String, String>) {
        inforModel.onInforList(context,params,object : IModelCallback<InforListBean>{
            override fun sucess(data: InforListBean) {
                iinforView.onSuccessInfor(data)
            }

            override fun failure(string: String) {
                iinforView.onFailInfor(string)
            }

        })
    }
}