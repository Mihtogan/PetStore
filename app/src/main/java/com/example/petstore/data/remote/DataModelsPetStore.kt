package com.example.petstore.data.remote

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("code")
    val code: Int,

    @SerializedName("type")
    val type: String,

    @SerializedName("message")
    val message: String,
)

data class Category(
    val id: Long,
    val name: String,
)

data class Pet(
    val id: Long,
    val category: Category,
    val photoUrls: List<String>,
    val tags: List<Tag>,
    val status: Statuses,
)

data class Tag(
    val id: Long,
    val name: String,
)

data class Order(
    val id: Long,
    val petId: Long,
    val quantity: Int,
    val shipDate: String,
    val status: Statuses,
    val complete: Boolean,
)

data class User(
    val id: Long,
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val userStatus: Int,
)

enum class Statuses {
    available, pending, sold
}