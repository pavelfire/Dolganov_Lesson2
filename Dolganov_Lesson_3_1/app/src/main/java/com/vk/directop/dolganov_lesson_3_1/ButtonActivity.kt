package com.vk.directop.dolganov_lesson_3_1

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.vk.directop.dolganov_lesson_3_1.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityButtonBinding

    private val token = Any()
    private val handler = Handler(Looper.getMainLooper())

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            mainBtn.setCcvTitle("Android Trainee")

            mainBtn.setCcvImage(getDrawable(R.drawable.a_logo))

            mainBtn.setListener {
                if (it == OnCustomCallbackViewAction.PUSH){
                    mainBtn.isProgressMode = true
                    handler.postDelayed({
                        mainBtn.isProgressMode = false
                        mainBtn.setCcvSubtitle("Стажировка по направлению Android")
                        Toast.makeText(this@ButtonActivity, "may be data loaded", Toast.LENGTH_LONG).show()
                    }, token, 2000)

                }



            }
        }
    }
}