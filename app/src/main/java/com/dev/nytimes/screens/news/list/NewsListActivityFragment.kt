package com.dev.nytimes.screens.news.list

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.nytimes.R
import com.dev.nytimes.constants.API_KEY
import com.dev.nytimes.models.news.AllNews
import com.dev.nytimes.models.news.AllNewsResult
import com.dev.nytimes.platform.BaseFragment
import com.dev.nytimes.platform.BaseViewModelFactory
import com.dev.nytimes.platform.LiveDataWrapper
import com.dev.nytimes.screens.news.detail.NewsDetailActivity
import kotlinx.android.synthetic.main.fragment_main_activity.*
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.android.inject

/**
 * News List Fragment.
 * Handles UI.
 * Fires rest api initiation.
 */
class NewsListActivityFragment : BaseFragment(),OnItemClickListener {

    companion object{
        fun getMainActivityFragment() = NewsListActivityFragment()
    }

    //---------------Class variables---------------//

    private val mNewsUseCase : NewsListUseCase by inject()
    private val mBaseViewModelFactory : BaseViewModelFactory =
        BaseViewModelFactory(Dispatchers.Main, Dispatchers.IO,mNewsUseCase)
    private val TAG = NewsListActivityFragment::class.java.simpleName
    private val mApiKey = API_KEY
    lateinit var mRecyclerViewAdapter: NewsListRecyclerViewAdapter

    private val mViewModel : NewsListActivityViewModel by lazy {
        ViewModelProviders.of(this,mBaseViewModelFactory)
            .get(NewsListActivityViewModel::class.java)    }

    //---------------Life Cycle---------------//

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Start observing the targets
        this.mViewModel.mAllResponse.observe(this, this.mDataObserver)
        this.mViewModel.mLoadingLiveData.observe(this, this.loadingObserver)

        mRecyclerViewAdapter = NewsListRecyclerViewAdapter(activity!!, arrayListOf(),this)

        landingListRecyclerView.adapter = mRecyclerViewAdapter
        landingListRecyclerView.layoutManager = LinearLayoutManager(activity!!)


        this.mViewModel.requestALLActivityData(mApiKey)
    }

    //---------------Observers---------------//
    private val mDataObserver = Observer<LiveDataWrapper<AllNews>> { result ->
        when (result?.responseRESPONSESTATUS) {
            LiveDataWrapper.RESPONSESTATUS.LOADING -> {
                // Loading data
            }
            LiveDataWrapper.RESPONSESTATUS.ERROR -> {
                // Error for http request
                logD(TAG,"LiveDataResult.Status.ERROR = ${result.response}")
                error_holder.visibility = View.VISIBLE
                showToast("Error in getting data")

            }
            LiveDataWrapper.RESPONSESTATUS.SUCCESS -> {
                // Data from API
                logD(TAG,"LiveDataResult.Status.SUCCESS = ${result.response}")
                val mainItemReceived = result.response as AllNews
                val  listItems =  mainItemReceived.results as ArrayList<AllNewsResult>
                processData(listItems)
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_main_activity

    /**
     * Handle success data
     */
    private fun processData(listItems: ArrayList<AllNewsResult>) {
        logD(TAG,"processData called with data ${listItems.size}")
        logD(TAG,"processData listItems =  ${listItems}")

        val refresh = Handler(Looper.getMainLooper())
        refresh.post {
            mRecyclerViewAdapter.updateListItems(listItems)
        }
    }

    /**
     * Hide / show loader
     */
    private val loadingObserver = Observer<Boolean> { visible ->
        // Show hide progress bar
        if(visible){
            progress_circular.visibility = View.VISIBLE
        }else{
            progress_circular.visibility = View.INVISIBLE
        }
    }

    override fun onItemClicked(news: AllNewsResult) {
        activity?.let{
//            intent.putExtra("story",intent)
            it.startActivity(Intent (it, NewsDetailActivity::class.java).apply {

                putExtra("story",news)
            })


        }
    }
}
