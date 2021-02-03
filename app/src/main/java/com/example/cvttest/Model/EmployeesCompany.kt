package com.example.cvttest.Model


import com.google.gson.annotations.SerializedName

data class EmployeesCompany(
    @SerializedName("company")
    val company: Company
)
