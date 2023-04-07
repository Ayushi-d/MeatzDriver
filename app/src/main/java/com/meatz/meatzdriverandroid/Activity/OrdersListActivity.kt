package com.meatz.meatzdriverandroid.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.meatz.meatzdriverandroid.Models.OrderModel
import com.meatz.meatzdriverandroid.R
import com.meatz.meatzdriverandroid.adapters.OrderListAdapter
import com.meatz.meatzdriverandroid.databinding.ActivityLoginBinding
import com.meatz.meatzdriverandroid.databinding.ActivityMainBinding
import com.meatz.meatzdriverandroid.databinding.ActivityOrdersListBinding

class OrdersListActivity : AppCompatActivity() {


    lateinit var binding : ActivityOrdersListBinding
    val data = ArrayList<OrderModel>()
    lateinit var adpter: OrderListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun handleViewClicks(){

    }

    private fun setupRecyclerView(){
        for (i in 1..20) {
            data.add(OrderModel(i,"","","Confirmed"))
        }
        binding.orderlistRV.layoutManager = LinearLayoutManager(this)
        adpter = OrderListAdapter(data)
        binding.orderlistRV.adapter = adpter
        adpter.onItemClick = {

        }
    }

    private fun setupTabs(){
        binding.appBarLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.position == 1){
                    for (i in 1..20) {
                        data.add(OrderModel(i,"","","Delivered"))
                    }
                }else{
                    for (i in 1..20) {
                        data.add(OrderModel(i,"","","Delivered"))
                    }
                }
                adpter.notifyDataSetChanged()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

}