package com.wd.tech.contact

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wd.tech.bean.InforBannerBean
import com.wd.tech.bean.InforListBean

/**
 * FileName: InforContact
 * Author: 杨明森
 * Date: 2019/4/8 15:44
 */
interface InforContact {

    /**
     * 资讯View回调
     */
    interface IinforView{
        fun onSuccessBanner(inforBannerBean : InforBannerBean)
        fun onFailBanner(string: String)

        /**
         * 资讯首页
         */
        fun onSuccessInfor(inforListBean : InforListBean)
        fun onFailInfor(string: String)
    }

    /**
     * 资讯Model
     */
    interface IinforModel{
        fun onBanner(context: Context,iModelCallback : IModelCallback<InforBannerBean>)
        fun onInforList(context: Context,params : HashMap<String,String>,iModelCallback : IModelCallback<InforListBean>)
    }

    /**
     * 资讯Presenter
     */
    interface IinforPresenter{
        fun onBanner(context: Context)
        fun onInforList(context: Context,params : HashMap<String,String>)
    }
}