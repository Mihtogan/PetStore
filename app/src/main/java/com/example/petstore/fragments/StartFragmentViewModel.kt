package com.example.petstore.fragments

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class StartFragmentViewModel @Inject constructor(val retrofit: Retrofit) : ViewModel() {

}