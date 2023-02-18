package com.vk.directop.dolganov_lesson_3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.constraintlayout.widget.Group

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aLogo = findViewById<ImageView>(R.id.a_logo)
        val btContacts = findViewById<Button>(R.id.bt_contacts)
        val btVacancies = findViewById<Button>(R.id.bt_vacancies)
        val btGallery = findViewById<Button>(R.id.bt_gallery)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val group = findViewById<Group>(R.id.group)

        btContacts.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            group.visibility = View.INVISIBLE
        }

        btVacancies.setOnClickListener {
            startActivity(Intent(this, ButtonActivity::class.java))
        }

        btGallery.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            group.visibility = View.INVISIBLE
        }

        aLogo.setOnClickListener {
            progressBar.visibility = View.INVISIBLE
            group.visibility = View.VISIBLE
        }


    }


}