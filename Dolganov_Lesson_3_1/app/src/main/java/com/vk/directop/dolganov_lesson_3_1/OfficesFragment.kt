package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vk.directop.dolganov_lesson_3_1.placeholder.OfficePlaceholderContent

class OfficesFragment : Fragment(), OfficeRecyclerViewAdapter.OnVacancyListener {

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
        val view = inflater.inflate(R.layout.fragment_offices_list, container, false)

        activity?.setTitle(R.string.offices)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = OfficeRecyclerViewAdapter(
                    OfficePlaceholderContent.ITEMS,
                    object : OfficeRecyclerViewAdapter.OnVacancyListener {
                        override fun onVacancyClick(vacancy: OfficePlaceholderContent.OfficeItem) {
                            requireActivity().supportFragmentManager.beginTransaction()
                                .replace(
                                    R.id.fragment_container, OfficeAddressFragment.newInstance(
                                        vacancy.city,
                                        vacancy.address,
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

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            OfficesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun onVacancyClick(vacancy: OfficePlaceholderContent.OfficeItem) {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container, OfficesFragment.newInstance(
                    1
                )
            )
            .commit()
    }
}