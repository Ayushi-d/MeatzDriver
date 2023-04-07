package com.meatz.meatzdriverandroid.Fragments

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.meatz.meatzdriverandroid.adapters.OrderDetailAdapter
import com.meatz.meatzdriverandroid.databinding.FragmentDetailsFragementBinding


class DetailsFragment : Fragment() {

    lateinit var binding : FragmentDetailsFragementBinding
    lateinit var adpter: OrderDetailAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsFragementBinding.inflate(layoutInflater,container,false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView(){

        //orders
        binding.orderStatusRV.layoutManager = LinearLayoutManager(activity)
        adpter = OrderDetailAdapter(null,requireActivity())
        binding.orderStatusRV.adapter = adpter
        adpter.onDialerClick = {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+96564328754")
            startActivity(intent)
        }

        //Destination
        binding.orderDestinationRV.layoutManager = LinearLayoutManager(activity)
        adpter = OrderDetailAdapter(null,requireActivity())
        binding.orderDestinationRV.adapter = adpter

        adpter.onDialerClick = {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+96564328754")
            startActivity(intent)
        }

    }

}