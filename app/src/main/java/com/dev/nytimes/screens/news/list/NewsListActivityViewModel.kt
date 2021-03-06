package com.dev.nytimes.screens.news.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.nytimes.models.news.AllNews
import com.dev.nytimes.platform.LiveDataWrapper
import kotlinx.coroutines.*
import org.koin.core.KoinComponent

/**
 * News View Model.
 * Handles connecting with corresponding Use Case.
 * Getting back data to View.
 */

class NewsListActivityViewModel(
    mainDispatcher: CoroutineDispatcher,
    ioDispatcher: CoroutineDispatcher,
    private val useCase: NewsListUseCase
) : ViewModel(), KoinComponent
     {

    var mAllResponse = MutableLiveData<LiveDataWrapper<AllNews>>()
    val mLoadingLiveData = MutableLiveData<Boolean>()
     private val job = SupervisorJob()
     private val mUiScope = CoroutineScope(mainDispatcher + job)
     private val mIoScope = CoroutineScope(ioDispatcher + job)

    init {
        //call reset to reset all VM data as required
        resetValues()
    }

    //Reset any member as per flow
    fun resetValues() {

    }

    //can be called from View explicitly if required
    //Keep default scope
    fun requestALLActivityData(param:String) {
        if(mAllResponse.value == null){
            mUiScope.launch {
                mAllResponse.value = LiveDataWrapper.loading()
                setLoadingVisibility(true)
                try {
                    val data = mIoScope.async {
                        return@async useCase.processNewsUseCase(param)
                    }.await()
                    try {
                        mAllResponse.value = LiveDataWrapper.success(data)
                    } catch (e: Exception) {
                    }
                    setLoadingVisibility(false)
                } catch (e: Exception) {
                    setLoadingVisibility(false)
                    mAllResponse.value = LiveDataWrapper.error(e)
                }
            }
        }
    }

    private fun setLoadingVisibility(visible: Boolean) {
        mLoadingLiveData.postValue(visible)
    }

    override fun onCleared() {
        super.onCleared()
        this.job.cancel()
    }
}