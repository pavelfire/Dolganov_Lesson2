package com.vk.directop.dolganov_lesson_3_1

import android.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.vk.directop.dolganov_lesson_3_1.databinding.FragmentLoginBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)

        with(binding){
            buttonLogin.isEnabled = false
            buttonLogin.setOnClickListener {
                if (editPassword.text.toString() == "7"){
                    Log.d("ew", "ura")
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(com.vk.directop.dolganov_lesson_3_1.R.id.fragment_container, MainFragment.newInstance("w","r"))
                        .commit()

                }
            }

            editPassword.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    binding.buttonLogin.isEnabled = !s.isNullOrEmpty()
                }
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    binding.buttonLogin.isEnabled = !s.isNullOrEmpty()
                }
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    binding.buttonLogin.isEnabled = !s.isNullOrEmpty()
                }
            })
        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
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