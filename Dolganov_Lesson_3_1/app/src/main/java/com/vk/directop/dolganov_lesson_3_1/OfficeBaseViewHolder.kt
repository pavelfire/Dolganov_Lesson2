package com.vk.directop.dolganov_lesson_3_1

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemByBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemKzBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemRuBinding

abstract class OfficeBaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //abstract fun populate(item: OfficePlaceholder.OfficeItem, )
}

class RuViewHolder(val binding: OfficeItemRuBinding) : OfficeBaseViewHolder(binding.root)

class ByViewHolder(val binding: OfficeItemByBinding) : OfficeBaseViewHolder(binding.root)

class KzViewHolder(val binding: OfficeItemKzBinding) : OfficeBaseViewHolder(binding.root)

class AnotherViewHolder(val binding: OfficeItemBinding) : OfficeBaseViewHolder(binding.root)