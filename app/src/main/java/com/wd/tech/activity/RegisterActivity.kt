package com.wd.tech.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wd.tech.R
import com.wd.tech.bean.RegisterBean
import com.wd.tech.contact.RigisterContact
import com.wd.tech.presenter.RigisterPresenter
import com.wd.tech.utils.ConstantLibrary
import com.wd.tech.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() ,RigisterContact.IRigisterView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar!!.hide()

        initView()
    }

    private fun initView() {
        var rigisterPresenter = RigisterPresenter(this)
        register_btn.setOnClickListener {
            //进行注册
            var nickName =register_name.text.toString()
            var phone =register_phone.text.toString()
            var pwd = register_pwd.text.toString()
            //密码加密
            val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwd)
            var params = HashMap<String,String>()
            params["nickName"] = nickName
            params["phone"] = phone
            params["pwd"] = encryptByPublicKey
            rigisterPresenter.toRigister(this,params)
        }
    }

    override fun onSuccessRigister(rigisterBean: RegisterBean) {
        Toast.makeText(this,rigisterBean.message, Toast.LENGTH_LONG).show()
        intent.putExtra("phone",register_phone.text.toString())
        intent.putExtra("pwd",register_pwd.text.toString())
        setResult(ConstantLibrary.REGINSETR_RESULTCORD,intent)
        finish()
    }

    override fun onFailRigister(string: String) {
        Toast.makeText(this,string, Toast.LENGTH_LONG).show()
    }
}
