package com.example.mynetworklearning.data.model


import com.google.gson.annotations.SerializedName

data class NonAlcoholsResponse(
    @SerializedName("drinks")
    val drinks: List<DrinkNonAlcohol>? = listOf()
)