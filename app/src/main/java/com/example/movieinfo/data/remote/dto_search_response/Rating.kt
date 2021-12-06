package com.example.movieinfo.data.remote.dto_search_response


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("Source")
    val source: String = "",
    @SerializedName("Value")
    val value: String = ""
)