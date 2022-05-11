package com.example.bottomnavigation_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.bottomnavigation_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        replaceFragment(HomeFragment())
        setContentView(binding.root)

//        binding.bottomNavigationView.setOnItemSelectedListener { it
//            when(it)
//
//            return@setOnItemSelectedListener true
//        }

        binding.bottomNavigationView.setOnItemSelectedListener { item:MenuItem ->
            Log.d("MyLog", item.itemId.toString())
            when(item.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.person -> replaceFragment(PersonFragment())
                R.id.settings -> replaceFragment(SettingsFragment())
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}


