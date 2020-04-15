package com.dev.nytimes.platform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev.nytimes.screens.news.list.NewsListUseCase
import com.dev.nytimes.screens.news.list.NewsListActivityViewModel
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Base VM Factory for creation of different VM's
 */
class BaseViewModelFactory constructor(
    private val mainDispather: CoroutineDispatcher
    ,private val ioDispatcher: CoroutineDispatcher
    ,private val useCase: NewsListUseCase
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewsListActivityViewModel::class.java)) {
            NewsListActivityViewModel(mainDispather, ioDispatcher,useCase) as T
        } else {
            throw IllegalArgumentException("ViewModel Not configured") as Throwable
        }
    }
}