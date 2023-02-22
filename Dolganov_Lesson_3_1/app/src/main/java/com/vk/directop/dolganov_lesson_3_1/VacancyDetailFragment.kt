package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.vk.directop.dolganov_lesson_3_1.databinding.FragmentVacancyDetailBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class VacancyDetailFragment : Fragment() {

    lateinit var binding: FragmentVacancyDetailBinding


    private var param1: Int? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentVacancyDetailBinding.inflate(inflater)

        activity?.setTitle(R.string.vacancy_detail)

        Toast.makeText(activity, "Text: $param1 param2: $param2", Toast.LENGTH_LONG).show()

        with(binding) {
            tvTitle.text = param1.toString()
            tvSubtitle.text = "Received: $param2"
        }
        binding.tvSubtitle.text = "Received: $param2"



        return inflater.inflate(R.layout.fragment_vacancy_detail, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            VacancyDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}