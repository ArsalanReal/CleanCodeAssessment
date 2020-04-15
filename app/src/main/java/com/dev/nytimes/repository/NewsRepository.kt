package com.dev.nytimes.repository

import com.dev.nytimes.models.news.AllNews
import com.dev.nytimes.network.login.NewsAPIService
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Repository for Login Flow.
 * Requests data from either Network or DB.
 *
 */
class NewsRepository : KoinComponent {

    val mNewsAPIService: NewsAPIService by inject()
    /**
     * Request data from backend
     */
    suspend fun getNewsData(query: String): AllNews {

        return processDataFetchLogic(query)

    }

    suspend fun processDataFetchLogic(parameter:String): AllNews{

        for (x in 0 until 3){
            println(" Data manipulation prior to REST API request if required $x")
        }

        val dataReceived = mNewsAPIService.getNewsData(parameter)

        for (x in 0 until 3){
            println(" Data manipulation post REST API request if required $x")
        }

        return dataReceived
    }


}