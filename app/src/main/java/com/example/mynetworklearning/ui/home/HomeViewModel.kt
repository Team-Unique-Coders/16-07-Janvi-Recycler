package com.example.mynetworklearning.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynetworklearning.data.ApiDetails
import com.example.mynetworklearning.data.model.DrinkAlcohol
import com.example.mynetworklearning.data.model.DrinkNonAlcohol
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _drinksList = MutableLiveData<List<DrinkAlcohol>>()
    val drinksList: LiveData<List<DrinkAlcohol>> = _drinksList

    init {
        getCocktails()
    }

    fun getCocktails(){
        //start a coroutine to start a suspend function
        viewModelScope.launch {
            try {
                val response = ApiDetails.apiService.getCocktails() // or ApiDetails.cocktailService.vodka()
                _drinksList.postValue(response.drinks ?: emptyList())
            } catch (e: Exception) {
                e.printStackTrace()
                _drinksList.postValue(emptyList()) // Optional: show empty if error
            }
        }
    }
}