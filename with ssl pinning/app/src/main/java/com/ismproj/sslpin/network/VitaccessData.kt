package com.ismproj.sslpin.network

import com.google.gson.annotations.SerializedName

data class VitaccessData(

    @SerializedName("Name")
    var name: String,
    @SerializedName("Image")
    var imageUrl: String,
    @SerializedName("Date")
    var _date: String,

    @SerializedName("Time")
    var _time: String

) {
    fun getFollowers(): String {
        return "Date: " + _date
    }

    fun getFollowing(): String {
        return "Time: " + _time
    }
}