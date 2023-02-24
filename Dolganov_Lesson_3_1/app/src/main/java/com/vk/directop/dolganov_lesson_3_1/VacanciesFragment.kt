package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vk.directop.dolganov_lesson_3_1.OfficesFragment.Companion.ARG_COLUMN_COUNT
import com.vk.directop.dolganov_lesson_3_1.contract.HasCustomTitle
import com.vk.directop.dolganov_lesson_3_1.placeholder.PlaceholderContent

class VacanciesFragment : Fragment(), HasCustomTitle, VacancyRecyclerViewAdapter.OnVacancyListener {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vacancies_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = VacancyRecyclerViewAdapter(PlaceholderContent.ITEMS,
                    object : VacancyRecyclerViewAdapter.OnVacancyListener {
                        override fun onVacancyClick(vacancy: PlaceholderContent.VacancyItem) {
                            requireActivity().supportFragmentManager.beginTransaction()
                                .replace(
                                    R.id.fragment_container, VacancyDetailFragment.newInstance(
                                        vacancy.title,
                                        vacancy.subtitle,
                                        vacancy.whatToDo,
                                        vacancy.requirements,
                                        vacancy.socialPack
                                    )
                                )
                                .addToBackStack(null)
                                .commit()
                        }

                    }
                )
            }
        }
        return view
    }

    override fun getTitleRes(): Int = R.string.vacancies

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            VacanciesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun onVacancyClick(vacancy: PlaceholderContent.VacancyItem) {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container, VacancyDetailFragment.newInstance(
                    vacancy.title,
                    vacancy.subtitle,
                    vacancy.whatToDo,
                    vacancy.requirements,
                    vacancy.socialPack
                )
            )
            .commit()
    }
}