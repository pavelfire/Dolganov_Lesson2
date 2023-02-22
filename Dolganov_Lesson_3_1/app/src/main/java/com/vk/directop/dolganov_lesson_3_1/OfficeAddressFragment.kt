package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vk.directop.dolganov_lesson_3_1.databinding.FragmentCityAddressBinding

private const val ARG_CITY = "param1"
private const val ARG_ADDRESS = "param2"

class OfficeAddressFragment : Fragment() {

    private var city: String? = null
    private var address: String? = null

    lateinit var binding: FragmentCityAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            city = it.getString(ARG_CITY)
            address = it.getString(ARG_ADDRESS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityAddressBinding.inflate(inflater)

        activity?.title = "Адрес офиса в г. $city"

        binding.tvCity.text = city
        binding.tvAddress.text = address

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(city: String, address: String) =
            OfficeAddressFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CITY, city)
                    putString(ARG_ADDRESS, address)
                }
            }
    }
}