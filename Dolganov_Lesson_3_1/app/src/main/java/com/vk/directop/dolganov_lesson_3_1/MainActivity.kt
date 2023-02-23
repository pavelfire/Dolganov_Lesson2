package com.vk.directop.dolganov_lesson_3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"
private var received = 0

class MainActivity : AppCompatActivity() {

    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomMenu = findViewById(R.id.bottomNavigationView)

        bottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.main -> {
                    val menuFragment = MainFragment()
                    replaceFragment(menuFragment)
                }
                R.id.vacancies -> {
                    supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragment_container, MainFragment())
                        .addToBackStack("")
                        .replace(R.id.fragment_container, VacanciesFragment())
                        .commit()
                }
                R.id.offices -> {
                    supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragment_container, MainFragment())
                        .addToBackStack("")
                        .replace(R.id.fragment_container, OfficesFragment())
                        .commit()
                }
            }
            true
        }



        if (savedInstanceState == null){
            Log.d("TAG", "get SaveInstanceState")
            bottomMenu.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SplashFragment())
                .commit()
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager // обращаемся к fm
            .beginTransaction() //начать транзакцию
            .replace(R.id.fragment_container, fragment) // действие
            .commit() // закончить транзакцию
    }

    fun moveToNext() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LoginFragment.newInstance("w", "r"))
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("TAG", "onSaveInstanceState Called")
        outState.putInt(LAST_SELECTED_ITEM, received)
    }
}
