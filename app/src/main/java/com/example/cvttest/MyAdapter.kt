package com.example.cvttest

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cvttest.Model.Company
import com.example.cvttest.Model.Employee
import com.example.cvttest.Model.EmployeesCompany
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_view.*
import kotlinx.android.synthetic.main.item_view.view.*
import okhttp3.internal.concurrent.formatDuration

class MyAdapter(private val dataList: MutableList<Employee>) :
    RecyclerView.Adapter<MyHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]


        val nameEmployee = holder.itemView.nameEmployee
        val phone = holder.itemView.phone
        val skills = holder.itemView.skills

        if (data.name.isNullOrEmpty()) {

            nameEmployee.text = "NoName"
            holder.itemView.setOnClickListener {
                Toast.makeText(context, "Нет Имени ", Toast.LENGTH_SHORT).show()
            }

        } else {

            
            nameEmployee?.text = "Name:" + data.name
            holder.itemView.setOnClickListener {
                Toast.makeText(context, data.name, Toast.LENGTH_SHORT).show()
            }
        }
        if (data.phoneNumber.isNullOrEmpty()) {

            phone.text = "Phone: No"
        } else {
            phone.text = "Phone:" + data.phoneNumber
        }
        try {
            if (skills.text != "" || skills.text != "null") {
                skills.text = "Skills:" + data.skills.toString()
            }
        } catch (e: Exception) {
            skills.text = "Skills: No"
        }

    }

    override fun getItemCount() = dataList.size
}