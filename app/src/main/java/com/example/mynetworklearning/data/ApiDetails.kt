package com.example.mynetworklearning.data

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiDetails {

    // https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic
    const val BASE_URL = "https://www.thecocktaildb.com/api/"
    const val END_POINT1 = "json/v1/1/filter.php?a=Alcoholic"
    const val END_POINT2 = "json/v1/1/filter.php?a=Non_Alcoholic"
    const val END_POINT3 = "json/v1/1/filter.php?i=Vodka"



    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val apiService = retrofit.create(CocktailService::class.java) //::class.java -> gives the equivalent name


}