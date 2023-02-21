package com.vk.directop.dolganov_lesson_3_1

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.vk.directop.dolganov_lesson_3_1.placeholder.PlaceholderContent.PlaceholderItem
import com.vk.directop.dolganov_lesson_3_1.databinding.FragmentVacanciesBinding
import com.vk.directop.dolganov_lesson_3_1.placeholder.PlaceholderContent

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class VacancyRecyclerViewAdapter(
    private val values: List<PlaceholderContent.VacancyItem>
) : RecyclerView.Adapter<VacancyRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentVacanciesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.title
        holder.contentView.text = item.subtitle
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentVacanciesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.btnTitle
        val contentView: TextView = binding.btnSubtitle

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}