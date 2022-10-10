package com.caiquebrener.hqawesome.ui.hq.recyclerview

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.caiquebrener.hqawesome.databinding.FragmentItemBinding

class MyHQViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val idView: TextView = binding.itemNumber
    val contentView: TextView = binding.content

    override fun toString(): String {
        return super.toString() + " '" + contentView.text + "'"
    }
}