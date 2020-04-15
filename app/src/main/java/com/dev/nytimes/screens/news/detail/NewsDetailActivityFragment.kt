package com.dev.nytimes.screens.news.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.dev.nytimes.R
import com.dev.nytimes.models.news.AllNewsResult
import com.dev.nytimes.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_news_detail.*
import kotlinx.android.synthetic.main.fragment_news_detail.title

/**
 * A placeholder fragment containing a simple view.
 */
class NewsDetailActivityFragment : BaseFragment() {

    companion object{
        fun getMainActivityFragment() = NewsDetailActivityFragment()
    }

    //---------------Life Cycle---------------//
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setNewsDetail(activity?.intent?.getParcelableExtra("story")!!)
    }

    override fun getLayoutId(): Int = R.layout.fragment_news_detail

    /**
     * Handle Intent Passing Data
     */
    private fun setNewsDetail(item: AllNewsResult) {

        item.let {
            title.text = it.title
            description.text = it._abstract
            date.text = it.published_date
            sectionStyle.text = "Section: "+it.section


            if (it.media.isNotEmpty()) {
                val imageList = it.media[0]
                if(imageList.mediaMetaData.size > 2) {
                    Glide.with(this)
                        .load(imageList.mediaMetaData[1].url)
                        .override(450,350)
                        .into(media)
                }
            }
        }

    }


}
