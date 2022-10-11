package com.caiquebrener.hqawesome.ui.hq.recyclerview

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.caiquebrener.hqawesome.databinding.FragmentItemBinding

class MyHQViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val idView: TextView = binding.titleItem
    val contentView: TextView = binding.contentItem

    override fun toString(): String {
        return super.toString() + " '" + contentView.text + "'"
    }
}