package com.dev.nytimes.models.news

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Sub data class for sample response.
 */
@Parcelize
data class AllNewsResult (
    @SerializedName("title")
    @Expose
    val title: String?=null,

    @SerializedName("published_date")
    @Expose
    val published_date : String?=null,

    @SerializedName("url")
    @Expose
    val url : String?=null,

    @SerializedName("abstract")
    @Expose
    val _abstract : String?=null,

    @SerializedName("byline")
    @Expose
    val byline : String?=null,

    @SerializedName("section")
    @Expose
    val section : String?=null,

    @SerializedName("media")
    @Expose
    val media : List<AllNewsResultMedia>
): Parcelable