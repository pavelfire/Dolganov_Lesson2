package com.vk.directop.dolganov_lesson_3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vk.directop.dolganov_lesson_3_1.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)



        with(binding) {


//            mainBtn.btnSubtitle.text = "Programmaticaly changed text"
//
//            mainBtn.root.setOnClickListener{
//                it.visibility = View.GONE
//                mainBtn.mainProgressBar.visibility = View.VISIBLE
            //           }
        }
    }
}