package com.vk.directop.dolganov_lesson_3_1

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemByBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemKzBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemRuBinding
import com.vk.directop.dolganov_lesson_3_1.placeholder.OfficePlaceholder

abstract class OfficeBaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun populate(
        item: OfficePlaceholder.OfficeItem,
        actionListener: OfficeRecyclerViewAdapter.OnOfficeListener
    )
}

class RuViewHolder(val binding: OfficeItemRuBinding) : OfficeBaseViewHolder(binding.root) {
    override fun populate(
        item: OfficePlaceholder.OfficeItem,
        actionListener: OfficeRecyclerViewAdapter.OnOfficeListener
    ) {
        with(binding) {
            tvTitle.text = item.city
            tvTitle.tag = item
            cardView.setOnClickListener {
                actionListener.onOfficeClick(item)
            }
        }
    }
}

class ByViewHolder(val binding: OfficeItemByBinding) : OfficeBaseViewHolder(binding.root) {
    override fun populate(
        item: OfficePlaceholder.OfficeItem,
        actionListener: OfficeRecyclerViewAdapter.OnOfficeListener
    ) {
        with(binding) {
            tvTitle.text = item.city
            tvTitle.tag = item
            cardView.setOnClickListener {
                actionListener.onOfficeClick(item)
            }
        }
    }
}

class KzViewHolder(val binding: OfficeItemKzBinding) : OfficeBaseViewHolder(binding.root) {
    override fun populate(
        item: OfficePlaceholder.OfficeItem,
        actionListener: OfficeRecyclerViewAdapter.OnOfficeListener
    ) {
        with(binding) {
            tvTitle.text = item.city
            tvTitle.tag = item
            cardView.setOnClickListener {
                actionListener.onOfficeClick(item)
            }
        }
    }
}

class AnotherViewHolder(val binding: OfficeItemBinding) : OfficeBaseViewHolder(binding.root) {
    override fun populate(
        item: OfficePlaceholder.OfficeItem,
        actionListener: OfficeRecyclerViewAdapter.OnOfficeListener
    ) {
        with(binding) {
            cardView.text = item.city
            cardView.tag = item
            cardView.setOnClickListener {
                actionListener.onOfficeClick(item)
            }
        }
    }
}