package com.dev.nytimes.screens.news.detail

import android.os.Bundle
import android.util.Log
import com.dev.nytimes.R
import com.dev.nytimes.platform.BaseActivity


class NewsDetailActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        configureAndShowFragment()
    }

    private fun configureAndShowFragment() {
        var fragment = supportFragmentManager.findFragmentById(R.id.bas_frame_layout) as NewsDetailActivityFragment?
        if(fragment == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.bas_frame_layout, NewsDetailActivityFragment.getMainActivityFragment())
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("destroy","destroy")
    }
}
