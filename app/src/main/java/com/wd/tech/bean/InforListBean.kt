package com.wd.tech.bean

/**
 * FileName: InforListBean
 * Author: 杨明森
 * Date: 2019/4/8 16:46
 */
data class InforListBean(
    val message: String,
    val result: List<Result>,
    val status: String
) {
    data class Result(
        val collection: Int,
        val id: Int,
        val infoAdvertisingVo: InfoAdvertisingVo,
        val releaseTime: Long,
        val share: Int,
        val source: String,
        val summary: String,
        val thumbnail: String,
        val title: String,
        val whetherAdvertising: Int,
        val whetherCollection: Int,
        val whetherPay: Int
    ) {
        data class InfoAdvertisingVo(
            val content: String,
            val id: Int,
            val pic: String,
            val url: String
        )
    }
}