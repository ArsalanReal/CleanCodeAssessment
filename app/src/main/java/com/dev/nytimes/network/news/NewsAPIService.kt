package com.dev.nytimes.network.login

import com.dev.nytimes.models.news.AllNews
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Login service Retrofit API.
 */
interface NewsAPIService{

    @GET("mostpopular/v2/viewed/1.json")
    suspend fun getNewsData(@Query("api-key") page:String): AllNews
}