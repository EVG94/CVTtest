package com.example.cvttest.Model

import io.reactivex.Single
import retrofit2.http.GET

interface QuestApi {

    @GET("/5ddcd3673400005800eae483")
    fun getQuestList():Single<EmployeesCompany>
}