package com.vk.directop.dolganov_lesson_3_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.dolganov_lesson_3_1.databinding.OfficeItemBinding
import com.vk.directop.dolganov_lesson_3_1.placeholder.OfficePlaceholderContent

class OfficeRecyclerViewAdapter(
    private val values: List<OfficePlaceholderContent.OfficeItem>,
    private val actionListener: OnVacancyListener
) : RecyclerView.Adapter<OfficeRecyclerViewAdapter.ViewHolder>(), View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = OfficeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.root.setOnClickListener(this)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.cardView.text = item.city

        holder.cardView.tag = item
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: OfficeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val cardView = binding.cardView
    }

    interface OnVacancyListener {
        fun onVacancyClick(vacancy: OfficePlaceholderContent.OfficeItem)
    }

    override fun onClick(view: View) {
        val vacancy = view.tag as OfficePlaceholderContent.OfficeItem
        when (view.id) {
            R.id.tv_title -> {}
            else -> {
                actionListener.onVacancyClick(vacancy)
            }
        }
    }
}