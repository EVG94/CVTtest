package com.example.cvttest.Model


import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: String,
    @SerializedName("competences")
    val competences: List<String>,
    @SerializedName("employees")
    val employees: List<Employee>

)