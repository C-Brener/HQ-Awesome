package com.caiquebrener.hqawesome.ui.hq.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.caiquebrener.hqawesome.databinding.FragmentItemBinding
import com.caiquebrener.hqawesome.placeholder.PlaceholderContent

class MyHQViewHolder(val binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val view = binding.root
    fun bindItem(item: PlaceholderContent.PlaceholderItem) {
        binding.hqItem = item
        binding.executePendingBindings()

//        Execute pendindg bind executa a atualização do binding em tempo real impedindo que os dados fiquem atrasados ou incorretos

    }
}