package com.example.mynetworklearning.data.model


import com.google.gson.annotations.SerializedName

data class DrinkVodka(
    @SerializedName("idDrink")
    val idDrink: String? = "",
    @SerializedName("strDrink")
    val strDrink: String? = "",
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String? = ""
)