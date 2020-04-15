package com.dev.nytimes.models.news

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Sub data class for sample response.
 */
@Parcelize
data class AllNewsResultImages (
    @SerializedName("url")
    @Expose
    val url : String,

    @SerializedName("format")
    @Expose
    val format : String,

    @SerializedName("height")
    @Expose
    val height : Int,

    @SerializedName("width")
    @Expose
    val width : Int
): Parcelable