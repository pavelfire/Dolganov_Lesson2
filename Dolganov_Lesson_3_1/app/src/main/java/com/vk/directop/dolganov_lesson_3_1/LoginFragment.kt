package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vk.directop.dolganov_lesson_3_1.databinding.FragmentLoginBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentLoginBinding

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
        binding = FragmentLoginBinding.inflate(inflater)

        activity?.setTitle(R.string.login_title)

        with(binding) {
            buttonLogin.isEnabled = false
            buttonLogin.setOnClickListener {
                if (editPassword.text.toString() == "7") {
                    Log.d("ew", "ura")

                    requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                        .visibility = View.VISIBLE
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.fragment_container,
                            MainFragment.newInstance("w", "r")
                        )
                        .commit()
                } else {
                    editPassword.setError("Неверный пароль", null)
                }
            }

            editPassword.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    binding.buttonLogin.isEnabled = s.isNotEmpty()
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    binding.buttonLogin.isEnabled = s.isNotEmpty()
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    binding.buttonLogin.isEnabled = s.isNotEmpty()
                }
            })
        }


        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}