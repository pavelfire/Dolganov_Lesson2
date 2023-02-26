package com.vk.directop.dolganov_lesson_3_1

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.dolganov_lesson_3_1.databinding.MainItemBottomBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.MainItemMiddleBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.MainItemTopBinding

abstract class MainBaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun populate(item: MainViewDto)

}

class MainTopViewHolder(private val binding: MainItemTopBinding) : MainBaseViewHolder(binding.root) {

    override fun populate(item: MainViewDto) {}

}

class MainMiddleViewHolder(private val binding: MainItemMiddleBinding) : MainBaseViewHolder(binding.root) {

    override fun populate(item: MainViewDto) {}

}

class MainBottomViewHolder(private val binding: MainItemBottomBinding) : MainBaseViewHolder(binding.root) {

    override fun populate(item: MainViewDto) {}

}


