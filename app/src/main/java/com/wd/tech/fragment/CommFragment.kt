package com.wd.tech.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wd.tech.R

/**
 * FileName: InformationFragment
 * Author: 杨明森
 * Date: 2019/4/8 14:23
 */
class CommFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(activity).inflate(R.layout.fragment_comm, container, false)
    }

}