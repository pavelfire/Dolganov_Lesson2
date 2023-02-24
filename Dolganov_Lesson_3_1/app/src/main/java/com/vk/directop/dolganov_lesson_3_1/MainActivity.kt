package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.vk.directop.dolganov_lesson_3_1.contract.HasCustomTitle
import com.vk.directop.dolganov_lesson_3_1.databinding.ActivityMainBinding

private const val LAST_SELECTED_ITEM = "item"
private var received = 0

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(R.id.fragment_container)!!

    private val fragmentListener = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)
            updateUi()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        setSupportActionBar(findViewById(R.id.toolbar))

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.main -> {
                    supportFragmentManager.popBackStack(
                        null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )
                    val menuFragment = MainFragment()
                    replaceFragment(menuFragment)
                }
                R.id.vacancies -> {
                    supportFragmentManager.popBackStack(
                        null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )
                    supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragment_container, MainFragment())
                        .addToBackStack("")
                        .replace(R.id.fragment_container, VacanciesFragment())
                        .commit()
                }
                R.id.offices -> {
                    supportFragmentManager.popBackStack(
                        null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )
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

        if (savedInstanceState == null) {
            Log.d("TAG", "get SaveInstanceState")
            binding.bottomNavigationView.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SplashFragment())
                .commit()
        }

        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, false)
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

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    private fun updateUi() {
        val fragment = currentFragment

        Log.d("TAG", "curFr: ${currentFragment.tag} IS it ${currentFragment.toString().take(8) == "MainFrag"} backStackEntryCount: ${supportFragmentManager.backStackEntryCount}")

        if (fragment is HasCustomTitle) {
            binding.toolbar.title = getString(fragment.getTitleRes())
        } else {
            binding.toolbar.title = getString(R.string.app_name)
        }

        if (supportFragmentManager.backStackEntryCount > 1) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(false)
        }
//        if (currentFragment.toString().take(8) == "MainFrag"){
//            binding.bottomNavigationView.selectedItemId = R.id.main
//        }
    }
}
