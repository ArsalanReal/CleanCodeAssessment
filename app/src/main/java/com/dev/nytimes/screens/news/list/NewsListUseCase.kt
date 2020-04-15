package com.dev.nytimes.screens.news.list

import com.dev.nytimes.models.news.AllNews
import com.dev.nytimes.repository.NewsRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Use Case class for handling News flow.
 * Requests data from Repo.
 * Process received data into required model and reverts back to ViewModel.
 */
class NewsListUseCase : KoinComponent {

    private val mNewsRepo : NewsRepository by inject()

    suspend fun processNewsUseCase(query: String) : AllNews {

        return  mNewsRepo.getNewsData(query)
    }
}