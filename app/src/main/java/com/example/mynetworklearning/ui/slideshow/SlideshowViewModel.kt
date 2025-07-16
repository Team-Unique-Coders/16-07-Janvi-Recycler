package com.example.mynetworklearning.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynetworklearning.data.ApiDetails
import com.example.mynetworklearning.data.model.DrinkVodka
import kotlinx.coroutines.launch

class SlideshowViewModel : ViewModel() {

    private val _drinksList = MutableLiveData<List<DrinkVodka>>()
    val drinksList: LiveData<List<DrinkVodka>> = _drinksList

    init {
        getVodkaDrinks()
    }

    fun getVodkaDrinks() {
        viewModelScope.launch {
            try {
                val response = ApiDetails.apiService.vodka() // or ApiDetails.cocktailService.vodka()
                _drinksList.postValue(response.drinks ?: emptyList())
            } catch (e: Exception) {
                e.printStackTrace()
                _drinksList.postValue(emptyList()) // Optional: show empty if error
            }
        }
    }
}