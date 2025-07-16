package com.example.mynetworklearning.data

import com.example.mynetworklearning.data.model.NonAlcoholsResponse
import com.example.mynetworklearning.data.model.AlcoholResponse
import com.example.mynetworklearning.data.model.VodkaResponse
import retrofit2.http.GET


interface CocktailService {
    @GET(ApiDetails.END_POINT1)
    suspend fun getCocktails(): AlcoholResponse

    @GET(ApiDetails.END_POINT2)
    suspend fun nonAlcoholic(): NonAlcoholsResponse

    @GET(ApiDetails.END_POINT3)
    suspend fun vodka(): VodkaResponse
}

