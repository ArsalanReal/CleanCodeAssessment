package com.dev.nytimes.models.news

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Sub data class for sample response.
 */
@Parcelize
data class AllNewsResultMedia (
    @SerializedName("media-metadata")
    @Expose
    val mediaMetaData : List<AllNewsResultImages>
): Parcelable