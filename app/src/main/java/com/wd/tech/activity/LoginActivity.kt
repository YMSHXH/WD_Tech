package com.wd.tech.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wd.tech.R
import com.wd.tech.bean.LoginBean
import com.wd.tech.contact.LoginContact
import com.wd.tech.presenter.LoginPresenter
import com.wd.tech.utils.ConstantLibrary
import com.wd.tech.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() ,LoginContact.ILoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()

        initView()

    }

    private fun initView() {
        var loginPresenter = LoginPresenter(this)
        login_btn.setOnClickListener {
            var phone =login_phone.text.toString()
            var pwd = login_pwd.text.toString()
            //密码加密
            val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwd)
            var params = HashMap<String,String>()
            params["phone"] = phone
            params["pwd"] = encryptByPublicKey
            loginPresenter.toLogin(this,params)

        }

        login_fast_reg.setOnClickListener {
            var intent = Intent(this,RegisterActivity::class.java)
            startActivityForResult(intent,ConstantLibrary.REGINSETR_REQUESTCORD)
        }
    }
    override fun onSuccessLogin(loginBean: LoginBean) {
        Toast.makeText(this,loginBean.message,Toast.LENGTH_LONG).show()
    }

    override fun onFailLogin(string: String) {
        Toast.makeText(this,string, Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (ConstantLibrary.REGINSETR_REQUESTCORD == requestCode && ConstantLibrary.REGINSETR_RESULTCORD == resultCode){
            login_phone.setText(data!!.getStringExtra("phone"))
            login_pwd.setText(data!!.getStringExtra("pwd"))
        }
    }
}
