package com.meatz.meatzdriverandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.meatz.meatzdriverandroid.Models.OrderModel
import com.meatz.meatzdriverandroid.R

class OrderDetailAdapter (private val mList: List<OrderModel>?, val context: Context) : RecyclerView.Adapter<OrderDetailAdapter.ViewHolder>() {

    var onDialerClick: (() -> Unit)? = null

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.orderdetail_item_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // val ItemsViewModel = mList!![position]
        val languages = context.resources.getStringArray(R.array.Status)
        val myString = "Status"

        if (holder.spstatus != null) {
            val adapter = ArrayAdapter(
                context,
                android.R.layout.simple_spinner_dropdown_item, languages
            )
            holder.spstatus.adapter = adapter
            holder.spstatus.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                 holder.tvStatus.text = languages[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        holder.dialIcon.setOnClickListener {
            onDialerClick?.invoke()
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return 2
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var spstatus: Spinner = ItemView.findViewById(R.id.spstatus)
        var tvStatus: TextView = ItemView.findViewById(R.id.tvStatus)
        var dialIcon: ImageView = ItemView.findViewById(R.id.dialIcon)

    }
}