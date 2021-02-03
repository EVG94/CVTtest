package com.example.cvttest.Model


import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?,
    @SerializedName("skills")
    val skills: List<String>
)
