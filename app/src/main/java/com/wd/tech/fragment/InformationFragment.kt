package com.wd.tech.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.stx.xhb.xbanner.XBanner
import com.wd.tech.R
import com.wd.tech.adapter.InforAdapter
import com.wd.tech.bean.InforBannerBean
import com.wd.tech.bean.InforListBean
import com.wd.tech.contact.InforContact
import com.wd.tech.presenter.InforPresenter
import com.wd.tech.utils.GlideImageLoader
import com.youth.banner.Banner
import kotlinx.android.synthetic.main.fragment_information.*



/**
 * FileName: InformationFragment
 * Author: 杨明森
 * Date: 2019/4/8 14:23
 */
class InformationFragment : Fragment() ,InforContact.IinforView{

    lateinit var inforPresenter: InforPresenter

    private var inforAdapter : InforAdapter? = null

    private var  bannerView :View? = null

    var list : List<InforBannerBean.Result>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initView()
        initData()
        return LayoutInflater.from(activity).inflate(R.layout.fragment_information, container, false)
    }

    private fun initView() {

    }

    private fun initData() {

        inforPresenter = InforPresenter(this)
        var params = HashMap<String, String>()
        params["page"] = "1"
        params["count"] = "10"
        inforPresenter.onInforList(this!!.activity!!,params)

    }


    override fun onSuccessInfor(inforListBean: InforListBean) {
        //请求banner轮播图
        inforPresenter.onBanner(this!!.activity!!)

        inforAdapter = InforAdapter(inforListBean.result)
        //设置样式
        recy_infor.layoutManager = LinearLayoutManager(activity)
        recy_infor.adapter = inforAdapter



        //添加轮播图
        bannerView= LayoutInflater.from(activity).inflate(R.layout.item_banner, null, false)
        inforAdapter!!.addHeaderView(bannerView)

    }

    override fun onFailInfor(string: String) {
        Toast.makeText(activity,string,Toast.LENGTH_LONG).show()
    }

    /**
     * banner录播图成功
     */
    override fun onSuccessBanner(inforBannerBean: InforBannerBean) {
        list = inforBannerBean.result
        if (bannerView != null) {
            var xBanner = bannerView!!.findViewById<XBanner>(R.id.xbanner)
            xBanner.loadImage { banner, model, view, position ->
                Glide.with(this!!.activity!!)
                    .load(this!!.list!![position].imageUrl)
                    .into(view as ImageView)
            }
        }
    }

    /**
     * banner轮播图失败
     */
    override fun onFailBanner(string: String) {
        Toast.makeText(activity,string,Toast.LENGTH_LONG).show()
    }
}