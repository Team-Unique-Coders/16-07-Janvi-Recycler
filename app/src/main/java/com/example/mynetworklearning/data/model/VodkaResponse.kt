package com.example.mynetworklearning.data.model


import com.google.gson.annotations.SerializedName

data class VodkaResponse(
    @SerializedName("drinks")
    val drinks: List<DrinkVodka>? = listOf()
)