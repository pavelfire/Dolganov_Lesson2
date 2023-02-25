package com.vk.directop.dolganov_lesson_3_1

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.dolganov_lesson_3_1.placeholder.OfficePlaceholder

abstract class OfficeBaseViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

    abstract fun populate(item: OfficePlaceholder.OfficeItem, )
}