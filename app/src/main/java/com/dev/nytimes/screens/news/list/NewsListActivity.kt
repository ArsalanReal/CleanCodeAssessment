package com.dev.nytimes.screens.news.list

import android.os.Bundle
import com.dev.nytimes.R
import com.dev.nytimes.platform.BaseActivity

/**
 * Activity holder for News Detail Flow.
 */
class NewsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureAndShowFragment()
    }

    private fun configureAndShowFragment() {
        var fragment = supportFragmentManager.findFragmentById(R.id.base_frame_layout) as NewsListActivityFragment?
        if(fragment == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.base_frame_layout, NewsListActivityFragment.getMainActivityFragment())
                .commit()
        }
    }
}
