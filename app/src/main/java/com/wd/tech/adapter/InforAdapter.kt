package com.wd.tech.adapter

import android.net.Uri
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.facebook.drawee.view.SimpleDraweeView
import com.wd.tech.R
import com.wd.tech.bean.InforListBean
import com.facebook.drawee.backends.pipeline.Fresco



/**
 * FileName: InforAdapter
 * Author: 杨明森
 * Date: 2019/4/8 18:45
 */
class InforAdapter(data : List<InforListBean.Result>) : BaseQuickAdapter<InforListBean.Result,
        BaseViewHolder>(R.layout.item_infor,data){
    override fun convert(helper: BaseViewHolder?, item: InforListBean.Result?) {
        helper!!.setText(R.id.title, item!!.title)
            .setText(R.id.summ,item.summary)

        val controller = Fresco.newDraweeControllerBuilder()
            .setUri(item.thumbnail)
            .setTapToRetryEnabled(true)
            .build()

        helper.getView<SimpleDraweeView>(R.id.simpleView).controller = controller
    }
}