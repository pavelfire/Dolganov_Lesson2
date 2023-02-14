package com.vk.directop.dolganov_lesson_3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btFrameLayout = findViewById<Button>(R.id.bt_frame_layout)
        val btLinearLayout = findViewById<Button>(R.id.bt_linear_layout)
        val btGridLayout = findViewById<Button>(R.id.bt_grid_layout)

        btFrameLayout.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }
        btLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
        btGridLayout.setOnClickListener {
            val intent = Intent(this, GridLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}