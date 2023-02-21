package com.vk.directop.dolganov_lesson_3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomMenu : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomMenu = findViewById(R.id.bottomNavigationView)

        bottomMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.main -> {
                    val menuFragment = MainFragment()
                    replaceFragment(menuFragment)
                }
                R.id.vacancies -> {
                    replaceFragment(VacanciesFragment())
                }
                R.id.offices -> {
                    replaceFragment(MainFragment())
                }
            }
            true
        }

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragment_container, LoginFragment.newInstance("w","r"))
//            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, VacanciesFragment.newInstance(1))
            .commit()


    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager // обращаемся к fm
            .beginTransaction() //начать транзакцию
            .replace(R.id.fragment_container, fragment) // действие
            .commit() // закончить транзакцию
    }
}