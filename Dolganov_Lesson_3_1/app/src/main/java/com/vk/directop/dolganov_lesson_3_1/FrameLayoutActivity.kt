package com.vk.directop.dolganov_lesson_3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class FrameLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)

        Toast.makeText(this, this.localClassName, Toast.LENGTH_LONG).show()
    }
}