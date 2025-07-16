package com.example.mynetworklearning.data.model


import com.google.gson.annotations.SerializedName

data class AlcoholResponse(
    @SerializedName("drinks")
    val drinks: List<DrinkAlcohol>? = listOf()
)