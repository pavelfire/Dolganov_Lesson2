package com.vk.directop.dolganov_lesson_3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btContacts = findViewById<Button>(R.id.bt_contacts)
        val btVacancies = findViewById<Button>(R.id.bt_vacancies)
        val btGallery = findViewById<Button>(R.id.bt_gallery)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        btContacts.setOnClickListener {
            progressBar.visibility = View.VISIBLE
        }
        btVacancies.setOnClickListener {
            progressBar.visibility = View.VISIBLE
        }
        btGallery.setOnClickListener {
            progressBar.visibility = View.VISIBLE
        }
        fun showProgress(){
            progressBar.visibility = View.VISIBLE

        }
    }


}