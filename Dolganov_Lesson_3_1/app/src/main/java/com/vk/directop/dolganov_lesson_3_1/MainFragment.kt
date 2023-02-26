package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vk.directop.dolganov_lesson_3_1.contract.HasCustomTitle
import com.vk.directop.dolganov_lesson_3_1.databinding.MainRecyclerBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment(), HasCustomTitle {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: MainRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainRecyclerBinding.inflate(inflater)

        with(binding.list) {
            layoutManager = LinearLayoutManager(context)
            adapter = MainRecyclerViewAdapter(valuesForMainFragment)
        }

        return binding.root
    }

    override fun getTitleRes(): Int = R.string.main

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        val valuesForMainFragment = listOf<MainViewDto>(
            TopMainRecyclerDto(
                greetingPic = R.drawable.greeting_pic,
            ),
            MiddleMainRecyclerDto(
                startLogo = R.drawable.flag_ru,
                text = "gfgff text here",
            ),
            BottomMainRecyclerDto(
                text = R.string.develop_programs,
            ),
        )
    }
}

interface MainViewDto {
    val viewType: Int
}

data class TopMainRecyclerDto(
    val greetingPic: Int,
    override val viewType: Int = R.layout.main_item_top
) : MainViewDto

data class MiddleMainRecyclerDto(
    val startLogo: Int,
    val text: String,
    override val viewType: Int = R.layout.main_item_middle
) : MainViewDto

data class BottomMainRecyclerDto(
    val text: Int,
    override val viewType: Int = R.layout.main_item_bottom
) : MainViewDto
