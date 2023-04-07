package com.meatz.meatzdriverandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.meatz.meatzdriverandroid.Models.OrderModel
import com.meatz.meatzdriverandroid.R

class OrderListAdapter(private val mList: List<OrderModel>) : RecyclerView.Adapter<OrderListAdapter.ViewHolder>() {

    var onItemClick: ((OrderModel) -> Unit)? = null

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_item_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.orderStatus.text = ItemsViewModel.orderStatus
        holder.btnOrderDetail.setOnClickListener{
            onItemClick?.invoke(ItemsViewModel)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return 2
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var orderStatus: TextView = ItemView.findViewById(R.id.tv_orderstatus)
        var btnOrderDetail: AppCompatButton = ItemView.findViewById(R.id.btnDetails)

    }
}