package com.example.petstore.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PetStoreApi {

    @GET("pet/findByStatus")
    suspend fun getPetsFindByStatus(
        @Query("status") statuses: Statuses,
        @Query("status") statuses2: Statuses? = null,
        @Query("status") statuses3: Statuses? = null,
    ): List<Pet>
}