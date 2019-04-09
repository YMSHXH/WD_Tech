package com.wd.tech.model

import android.annotation.SuppressLint
import android.content.Context
import com.kotlinframework.net.network.*
import com.wd.tech.api.HomeService
import com.wd.tech.bean.InforBannerBean
import com.wd.tech.bean.InforListBean
import com.wd.tech.contact.InforContact

/**
 * FileName: InforModel
 * Author: 杨明森
 * Date: 2019/4/8 15:50
 */
class InforModel : InforContact.IinforModel {

    @SuppressLint("CheckResult")
    override fun onBanner(context: Context, iModelCallback: IModelCallback<InforBannerBean>) {
        RetrofitManager.instance.createService(HomeService::class.java)
            .getBanner()
            .compose(NetScheduler.compose())
            .subscribe(object : NetResponseObserver<InforBannerBean>(context){
                override fun success(data: InforBannerBean) {
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

    /**
     * 请求list集合
     */
    override fun onInforList(
        context: Context,
        params: HashMap<String, String>,
        iModelCallback: IModelCallback<InforListBean>
    ) {
        RetrofitManager.instance.createService(HomeService::class.java)
            .getInforList(params)
            .compose(NetScheduler.compose())
            .subscribe(object : NetResponseObserver<InforListBean>(context){
                override fun success(data: InforListBean) {
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