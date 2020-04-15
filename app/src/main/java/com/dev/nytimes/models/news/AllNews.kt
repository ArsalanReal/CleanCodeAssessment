package com.dev.nytimes.models.news

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Parent Data class for sample response.
 */
data class AllNews(

    @SerializedName("num_results")
    @Expose
    val count : Int,

    @SerializedName("status")
    @Expose
    val next : String,

    @SerializedName("copyright")
    @Expose
    val previous : String,

    @SerializedName("results")
    @Expose
    val results : List<AllNewsResult>

)