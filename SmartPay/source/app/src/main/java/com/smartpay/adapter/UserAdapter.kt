package com.smartpay.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartpay.databinding.ActivityUserItemBinding
import com.smartpay.model.User

class UserAdapter(private val userList: MutableList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var showOnlyFirstEight = true
    private var hideEighthItem = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actualPosition = if (hideEighthItem && position >= 7) position + 1 else position
        val user = userList[actualPosition]
        holder.bind(user)

        // Click listener for the 8th item to expand the list and hide itself
        if (position == 7 && showOnlyFirstEight) {
            holder.binding.root.setOnClickListener {
                showOnlyFirstEight = false
                hideEighthItem = true
                notifyDataSetChanged()
            }
        } else if (position == itemCount - 1 && !showOnlyFirstEight) {
            holder.binding.root.setOnClickListener {
                showOnlyFirstEight = true
                hideEighthItem = false
                notifyDataSetChanged()
            }
        } else {
            holder.binding.root.setOnClickListener(null)
        }

        // Show or hide items based on the flags
        if (showOnlyFirstEight && position >= 8) {
            holder.binding.root.visibility = android.view.View.GONE
        } else {
            holder.binding.root.visibility = android.view.View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return if (showOnlyFirstEight) 8 else userList.size - if (hideEighthItem) 1 else 0
    }

    class ViewHolder(val binding: ActivityUserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.userName.text = user.name
            binding.userImage.setImageResource(user.imageResId)
        }
    }
}
