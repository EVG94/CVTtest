package com.example.cvttest

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.cvttest.Model.Company
import com.example.cvttest.Model.Employee
import com.example.cvttest.Model.EmployeesCompany
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view.*


class MainActivity : AppCompatActivity() {
    private val dataList: MutableList<Employee> = mutableListOf()
    private val companyList: MutableList<Company> = mutableListOf()
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myAdapter = MyAdapter(dataList)

        myRV.layoutManager = LinearLayoutManager(this)
        myRV.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        myRV.adapter = myAdapter

        AndroidNetworking.initialize(this)
        AndroidNetworking.get("http://www.mocky.io/v2/5ddcd3673400005800eae483")

            .build()
            .getAsObject(
                EmployeesCompany::class.java, object : ParsedRequestListener<EmployeesCompany> {

                    @SuppressLint("SetTextI18n")
                    override fun onResponse(response: EmployeesCompany) {
                        val nameCom = findViewById<TextView>(R.id.nameCompany)

                        nameCom.text = "Name Company: " + response.company.name
                        ageCompany.text = "Age: " + response.company.age
                        competences.text = "Competence: " + response.company.competences.toString()

                        dataList.addAll(response.company.employees)
                        dataList.sortWith(nullsFirst(compareBy { it.name }))
                        myAdapter.notifyDataSetChanged()

                    }

                    override fun onError(anError: ANError?) {
                        Log.d("myTag", "$anError")

                    }
                })
    }

}