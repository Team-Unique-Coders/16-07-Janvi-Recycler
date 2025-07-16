package com.example.mynetworklearning.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynetworklearning.data.ApiDetails
import com.example.mynetworklearning.data.model.DrinkNonAlcohol
import com.example.mynetworklearning.data.model.DrinkVodka
import com.example.mynetworklearning.data.model.NonAlcoholsResponse
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {

    private val _drinksList = MutableLiveData<List<DrinkNonAlcohol>>()
    val drinksList: LiveData<List<DrinkNonAlcohol>> = _drinksList

    init {
        getNonAlcoholic()
    }

    fun getNonAlcoholic() {
        viewModelScope.launch {
            try {
                val response = ApiDetails.apiService.nonAlcoholic() // or ApiDetails.cocktailService.vodka()
                _drinksList.postValue(response.drinks ?: emptyList())
            } catch (e: Exception) {
                e.printStackTrace()
                _drinksList.postValue(emptyList()) // Optional: show empty if error
            }
        }
    }
}