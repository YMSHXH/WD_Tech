package com.wd.tech.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.wd.tech.R
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        initTime()

    }

    var handler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 1001){
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }



    private fun initTime() {
        //执行耗时操作开启子线程
        // 1. 创建单线程化线程池
        val singleThreadExecutor = Executors.newSingleThreadExecutor()

        // 2. 创建好Runnable类线程对象 & 需执行的任务
        val task = Runnable {
            //开启handler
            handler.sendEmptyMessageAtTime(1001,1000)
        }

        // 3. 向线程池提交任务：execute（）
        singleThreadExecutor.execute(task)

        // 4. 关闭线程池
        singleThreadExecutor.shutdown()

    }


}
