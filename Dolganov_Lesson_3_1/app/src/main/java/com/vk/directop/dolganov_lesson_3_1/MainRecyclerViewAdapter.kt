package com.vk.directop.dolganov_lesson_3_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.dolganov_lesson_3_1.databinding.MainItemBottomBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.MainItemMiddleBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.MainItemTopBinding

class MainRecyclerViewAdapter(
    private val values: List<MainViewDto>,
) : RecyclerView.Adapter<MainBaseViewHolder>() {

    override fun getItemViewType(position: Int) = values[position].viewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainBaseViewHolder {

        return when (viewType) {
            R.layout.main_item_top -> MainTopViewHolder(
                MainItemTopBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    )
                )
            )
            R.layout.main_item_middle -> MainMiddleViewHolder(
                MainItemMiddleBinding.inflate(
                    LayoutInflater.from(parent.context)
                )
            )
            else -> MainBottomViewHolder(MainItemBottomBinding.inflate(LayoutInflater.from(parent.context)))
        }
    }

    override fun onBindViewHolder(holder: MainBaseViewHolder, position: Int) {
        holder.populate(values[position])
    }

    override fun getItemCount(): Int = values.size

}