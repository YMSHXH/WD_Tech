package com.wd.tech.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wd.tech.R
import com.wd.tech.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_start.*

/**
 * FileName: InformationFragment
 * Author: 杨明森
 * Date: 2019/4/8 14:23
 */
class StartFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(activity).inflate(R.layout.fragment_start, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        toLogin_iamge.setOnClickListener { startActivity(Intent(activity,LoginActivity::class.java)) }
        toLogin_text.setOnClickListener { startActivity(Intent(activity,LoginActivity::class.java)) }
    }

}