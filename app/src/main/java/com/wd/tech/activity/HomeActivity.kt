package com.wd.tech.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import com.wd.tech.R
import com.wd.tech.fragment.CommFragment
import com.wd.tech.fragment.InformationFragment
import com.wd.tech.fragment.MessageFragment
import com.wd.tech.fragment.StartFragment
import kotlinx.android.synthetic.main.activity_home.*
import android.view.MenuItem


class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_infor -> {
                pager.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_message -> {
                pager.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_comm -> {
                pager.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        pager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(i: Int): Fragment? {
                when (i) {
                    0 -> return InformationFragment()
                    1 -> return MessageFragment()
                    2 -> return CommFragment()
                }

                return null
            }

            override fun getCount(): Int {
                return 3
            }
        }
        initViewStart()

    }

    private fun initViewStart() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //获取布局
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.left_drawer,StartFragment())
            .commit()

        //设置中间人
        toggle  = ActionBarDrawerToggle(this,container,
            R.string.drawer_open,R.string.drawer_class)

        //设置同步
        toggle.syncState();

        //添加 drawer 监听
        container.addDrawerListener(toggle)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}
