package com.vk.directop.dolganov_lesson_3_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.dolganov_lesson_3_1.databinding.VacancyItemBinding
import com.vk.directop.dolganov_lesson_3_1.placeholder.PlaceholderContent

class VacancyRecyclerViewAdapter(
    private val values: List<PlaceholderContent.VacancyItem>,
    private val actionListener: OnVacancyListener
) : RecyclerView.Adapter<VacancyRecyclerViewAdapter.ViewHolder>(), View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = VacancyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.root.setOnClickListener(this)
        binding.cardView.setOnClickListener(this)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.vacancyTitle.text = item.title
        holder.vacancySubtitle.text = item.subtitle

        holder.cardView.tag = item
        holder.vacancyTitle.tag = item
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: VacancyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val vacancyTitle: TextView = binding.tvTitle
        val vacancySubtitle: TextView = binding.tvSubtitle

        val cardView = binding.cardView

        override fun toString(): String {
            return super.toString() + " '" + vacancySubtitle.text + "'"
        }
    }

    interface OnVacancyListener {
        fun onVacancyClick(vacancy: PlaceholderContent.VacancyItem)
    }

    override fun onClick(view: View) {
        val vacancy = view.tag as PlaceholderContent.VacancyItem
        when (view.id) {
            R.id.tv_title -> {}
            else -> {
                actionListener.onVacancyClick(vacancy)
            }
        }
    }
}