package com.vk.directop.dolganov_lesson_3_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemByBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemKzBinding
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemRuBinding
import com.vk.directop.dolganov_lesson_3_1.placeholder.OfficePlaceholder

class OfficeRecyclerViewAdapter(
    private val values: List<OfficePlaceholder.OfficeItem>,
    private val actionListener: OnOfficeListener
) : RecyclerView.Adapter<OfficeBaseViewHolder>(), View.OnClickListener {

    override fun getItemViewType(position: Int) = values[position].viewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficeBaseViewHolder {

        return when (viewType) {
            1 -> RuViewHolder(OfficeItemRuBinding.inflate(LayoutInflater.from(parent.context)))
            2 -> ByViewHolder(OfficeItemByBinding.inflate(LayoutInflater.from(parent.context)))
            3 -> KzViewHolder(OfficeItemKzBinding.inflate(LayoutInflater.from(parent.context)))
            else -> AnotherViewHolder(OfficeItemBinding.inflate(LayoutInflater.from(parent.context)))
        }
    }

    override fun onBindViewHolder(holder: OfficeBaseViewHolder, position: Int) {
        when (holder) {
            is RuViewHolder -> {
                with(holder.binding) {
                    val item = values[position]
                    tvTitle.text = item.city
                    tvTitle.tag = item
                    cardView.setOnClickListener {
                        actionListener.onOfficeClick(item)
                    }
                }
            }
            is ByViewHolder -> {
                with(holder.binding) {
                    val item = values[position]
                    tvTitle.text = item.city
                    cardView.tag = item
                    cardView.setOnClickListener {
                        actionListener.onOfficeClick(item)
                    }
                }
            }
            is KzViewHolder -> {
                with(holder.binding) {
                    val item = values[position]
                    tvTitle.text = item.city
                    cardView.tag = item
                    cardView.setOnClickListener {
                        actionListener.onOfficeClick(item)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = values.size


    interface OnOfficeListener {
        fun onOfficeClick(vacancy: OfficePlaceholder.OfficeItem)
    }

    override fun onClick(view: View) {
        val office = view.tag as OfficePlaceholder.OfficeItem
        when (view.id) {
            R.id.tv_title -> {}
            else -> {
                actionListener.onOfficeClick(office)
            }
        }
    }
}