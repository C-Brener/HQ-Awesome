package com.caiquebrener.hqawesome.ui.hq.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caiquebrener.hqawesome.data.actions.HQItemListener
import com.caiquebrener.hqawesome.databinding.FragmentItemBinding
import com.caiquebrener.hqawesome.placeholder.PlaceholderContent.PlaceholderItem


class MyHQRecyclerViewAdapter(
    private val values: List<PlaceholderItem>,
    private val listener: HQItemListener
) : RecyclerView.Adapter<MyHQViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHQViewHolder {

        return MyHQViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: MyHQViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
        holder.view.setOnClickListener {
            listener.onItemSelected(position)
        }

    }

    override fun getItemCount(): Int = values.size


}