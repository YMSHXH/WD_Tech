package com.wd.tech.api

import com.wd.tech.bean.InforBannerBean
import com.wd.tech.bean.InforListBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * FileName: HomeService
 * Author: 杨明森
 * Date: 2019/4/8 15:42
 */
interface HomeService {
    /**
     * banner录播图
     */
    @GET(Apis.BANNER_URL)
    fun getBanner() : Observable<InforBannerBean>

    /**
     * 资讯首页数据
     */
    @GET(Apis.INFOR_LIST_URL)
    fun getInforList(@QueryMap params : HashMap<String,String>) : Observable<InforListBean>
}