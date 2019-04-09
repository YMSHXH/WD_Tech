package com.wd.tech.bean

/**
 * FileName: InforBannerBean
 * Author: 杨明森
 * Date: 2019/4/8 15:35
 */
data class InforBannerBean(
    val message: String,
    val result: List<Result>,
    val status: String
) {
    data class Result(
        val imageUrl: String,
        val jumpUrl: String,
        val rank: Int,
        val title: String
    )
}