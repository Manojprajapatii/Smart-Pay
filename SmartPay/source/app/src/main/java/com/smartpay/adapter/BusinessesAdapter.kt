package com.smartpay.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartpay.databinding.ActivityUserItemBinding
import com.smartpay.model.Businesses

class BusinessesAdapter(private val businessesList: MutableList<Businesses>) : RecyclerView.Adapter<BusinessesAdapter.ViewHolder>() {

    private var showOnlyFirstEight = true
    private var hideEighthItem = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Adjust position to account for the hidden 8th item
        val actualPosition = if (hideEighthItem && position >= 3) position + 1 else position
        val business = businessesList[actualPosition]
        holder.bind(business)

        // Click listener for the 8th item to expand the list and hide itself
        if (position == 3 && showOnlyFirstEight) {
            holder.binding.root.setOnClickListener {
                showOnlyFirstEight = false
                hideEighthItem = true
                notifyDataSetChanged()
            }
        }
        // Click listener for the last item to collapse the list and show the 8th item again
        else if (position == itemCount - 1 && !showOnlyFirstEight) {
            holder.binding.root.setOnClickListener {
                showOnlyFirstEight = true
                hideEighthItem = false
                notifyDataSetChanged()
            }
        } else {
            holder.binding.root.setOnClickListener(null)
        }

        // Show or hide items based on the flags
        if (showOnlyFirstEight && position >= 4) {
            holder.binding.root.visibility = android.view.View.GONE
        } else {
            holder.binding.root.visibility = android.view.View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return if (showOnlyFirstEight) {
            4.coerceAtMost(businessesList.size)
        } else {
            businessesList.size - if (hideEighthItem) 1 else 0
        }
    }

    class ViewHolder(val binding: ActivityUserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(business: Businesses) {
            binding.userName.text = business.name
            binding.userImage.setImageResource(business.imageResId)
        }
    }
}
