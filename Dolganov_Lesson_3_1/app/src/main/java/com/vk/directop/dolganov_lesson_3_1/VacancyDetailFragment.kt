package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vk.directop.dolganov_lesson_3_1.databinding.FragmentVacancyDetailBinding

private const val ARG_TITLE = "title"
private const val ARG_SUBTITLE = "subtitle"
private const val ARG_WHAT_TO_DO = "whatToDo"
private const val ARG_REQUIREMENTS = "requirements"
private const val ARG_SOCIAL_PACK = "socialPack"

class VacancyDetailFragment : Fragment() {

    private var title: String? = null
    private var subtitle: String? = null
    private var whatToDo: String? = null
    private var requirements: String? = null
    private var socialPack: String? = null

    lateinit var binding: FragmentVacancyDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            subtitle = it.getString(ARG_SUBTITLE)
            whatToDo = it.getString(ARG_WHAT_TO_DO)
            requirements = it.getString(ARG_REQUIREMENTS)
            socialPack = it.getString(ARG_SOCIAL_PACK)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentVacancyDetailBinding.inflate(inflater)

        activity?.setTitle(R.string.vacancy_detail)

        with(binding) {
            tvTitle.text = title
            tvSubtitle.text = subtitle
            tvWhatToDo.text = whatToDo
            tvRequirements.text = requirements
            tvSocialPack.text = socialPack


        }

        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance(title: String,
                        subtitle: String,
                        whatToDo: String,
                        requirements: String,
                        socialPack: String

        ) =
            VacancyDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_SUBTITLE, subtitle)
                    putString(ARG_WHAT_TO_DO, whatToDo)
                    putString(ARG_REQUIREMENTS, requirements)
                    putString(ARG_SOCIAL_PACK, socialPack)
                }
            }

    }
}