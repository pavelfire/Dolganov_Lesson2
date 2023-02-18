package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vk.directop.dolganov_lesson_3_1.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            mainBtn.setCcvTitle("Android Trainee")
            mainBtn.setCcvSubtitle("Стажировка по направлению Android")
            mainBtn.setCcvImage(getDrawable(R.drawable.a_logo))

            mainBtn.setListener {
                if (it == OnCustomCallbackViewAction.PUSH)
                    Toast.makeText(this@ButtonActivity, "pressed", Toast.LENGTH_LONG).show()
            }
        }
    }
}