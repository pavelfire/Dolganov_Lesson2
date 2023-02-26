package com.vk.directop.dolganov_lesson_3_1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.dolganov_lesson_3_1.databinding.VacancyItemBinding
import com.vk.directop.dolganov_lesson_3_1.placeholder.VacancyPlaceholder
import java.util.*

class VacancyRecyclerViewAdapter(
    private val values: List<VacancyPlaceholder.VacancyItem>,
    private val actionListener: OnVacancyListener
) : RecyclerView.Adapter<VacancyRecyclerViewAdapter.ViewHolder>(), View.OnClickListener,
    Filterable {

    var vacanciesFilterList = values

    init {
        vacanciesFilterList = values
    }

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
        val item = vacanciesFilterList[position]
        holder.vacancyTitle.text = item.title
        holder.vacancySubtitle.text = item.subtitle

        holder.cardView.tag = item
        holder.vacancyTitle.tag = item
    }

    override fun getItemCount(): Int = vacanciesFilterList.size

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
        fun onVacancyClick(vacancy: VacancyPlaceholder.VacancyItem)
    }

    override fun onClick(view: View) {
        val vacancy = view.tag as VacancyPlaceholder.VacancyItem
        when (view.id) {
            R.id.tv_title -> {}
            else -> {
                actionListener.onVacancyClick(vacancy)
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    vacanciesFilterList = values
                } else {
                    val resultList = mutableListOf<VacancyPlaceholder.VacancyItem>()
                    for (row in values) {
                        if (row.title.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                            Log.d("TAG", "Row: ${row.title}")
                        }
                    }
                    vacanciesFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = vacanciesFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                vacanciesFilterList = results?.values as List<VacancyPlaceholder.VacancyItem>
                notifyDataSetChanged()
            }
        }
    }
}