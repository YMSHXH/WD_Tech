package com.wd.tech.model

import android.content.Context
import com.kotlinframework.net.network.*
import com.wd.tech.api.UserService
import com.wd.tech.bean.RegisterBean
import com.wd.tech.contact.RigisterContact

/**
 * FileName: RigisterModle
 * Author: 杨明森
 * Date: 2019/4/9 20:28
 */
class RigisterModle : RigisterContact.IRigisterModle {
    override fun toRigister(
        context: Context,
        prams: HashMap<String, String>,
        iModelCallback: IModelCallback<RegisterBean>
    ) {
        RetrofitManager.instance.createService(UserService::class.java)
            .toRigister(prams)
            .compose(NetScheduler.compose())
            .subscribe(object : NetResponseObserver<RegisterBean>(context){
                override fun success(data: RegisterBean) {
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