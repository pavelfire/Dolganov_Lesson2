package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.vk.directop.dolganov_lesson_3_1.contract.HasCustomTitle
import com.vk.directop.dolganov_lesson_3_1.databinding.FragmentVacanciesListBinding
import com.vk.directop.dolganov_lesson_3_1.placeholder.VacancyPlaceholder

class VacanciesFragment : Fragment(), HasCustomTitle, VacancyRecyclerViewAdapter.OnVacancyListener {

    private var columnCount = 1

    lateinit var binding: FragmentVacanciesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentVacanciesListBinding.inflate(inflater)

        val myAdapter = VacancyRecyclerViewAdapter(VacancyPlaceholder.ITEMS,
            object : VacancyRecyclerViewAdapter.OnVacancyListener {
                override fun onVacancyClick(vacancy: VacancyPlaceholder.VacancyItem) {
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
        binding.vacancySearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("TAG", "submit pressed: $query")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                myAdapter.filter.filter(newText)
                Log.d("TAG", "new text: $newText")
                //adapter.filter.filter(newText)
                return false
            }

        })
        with(binding.list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = myAdapter
        }
        return binding.root
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

    override fun onVacancyClick(vacancy: VacancyPlaceholder.VacancyItem) {
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