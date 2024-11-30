package com.example.petstore.fragments

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petstore.data.remote.PetStoreApi
import com.example.petstore.data.remote.Statuses
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class StartFragmentViewModel @Inject constructor(val petStoreApi: PetStoreApi) : ViewModel() {

    fun getPetsByStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val pets = petStoreApi.getPetsFindByStatus(Statuses.available, Statuses.sold)
                Log.d("My_Log", pets.first().toString())
            } catch (e: Exception) {
                Log.e("My_Log", e.message.toString())
            }
        }
    }
}