package com.example.petstore.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petstore.R
import com.example.petstore.data.recyclers.PetCardItem
import com.example.petstore.data.remote.PetStoreApi
import com.example.petstore.data.remote.Statuses
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PetListFragmentViewModel @Inject constructor(val petStoreApi: PetStoreApi) : ViewModel() {
    private val _inputPets = MutableLiveData<List<PetCardItem>>()
    val inputPets: LiveData<List<PetCardItem>> = _inputPets

    fun getPets() {
        viewModelScope.launch {
            _inputPets.value = withContext(Dispatchers.IO) {
                petStoreApi.getPetsFindByStatus(Statuses.available).map {
                    PetCardItem(
                        image = R.drawable.image_2,
                        name = it.name.orEmpty(),
                        category = it.category?.name.orEmpty()
                    )
                }
            }
        }
    }
}