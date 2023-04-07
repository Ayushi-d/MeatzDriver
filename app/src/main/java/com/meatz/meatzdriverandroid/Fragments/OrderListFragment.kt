package com.meatz.meatzdriverandroid.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.meatz.meatzdriverandroid.Models.OrderModel
import com.meatz.meatzdriverandroid.R
import com.meatz.meatzdriverandroid.adapters.OrderListAdapter
import com.meatz.meatzdriverandroid.databinding.FragmentOrderListBinding

class OrderListFragment: Fragment()  {

    lateinit var binding : FragmentOrderListBinding
    val data = ArrayList<OrderModel>()
    lateinit var adpter: OrderListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderListBinding.inflate(layoutInflater,container,false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun handleViewClicks(){

    }

    private fun setupRecyclerView(){
        for (i in 1..20) {
            data.add(OrderModel(i,"","","Confirmed"))
        }
        binding.orderlistRV.layoutManager = LinearLayoutManager(activity)
        adpter = OrderListAdapter(data)
        binding.orderlistRV.adapter = adpter
        adpter.onItemClick = {
          changeFragment(requireContext(),DetailsFragment())
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

    fun changeFragment(context: Context, fragment: Fragment?) {
        val fragmentManager = (context as FragmentActivity).supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, fragment!!).addToBackStack(null)
            .commitAllowingStateLoss()
    }
}