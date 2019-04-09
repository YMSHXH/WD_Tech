package com.wd.tech.bean

/**
 * FileName: LoginBean
 * Author: 杨明森
 * Date: 2019/4/9 18:39
 */
data class LoginBean(
    val message: String,
    val result: Result,
    val status: String
) {
    data class Result(
        val headPic: String,
        val nickName: String,
        val phone: String,
        val pwd: String,
        val sessionId: String,
        val signature: String,
        val userId: Int,
        val userName: String,
        val whetherFaceId: Int,
        val whetherVip: Int
    )
}