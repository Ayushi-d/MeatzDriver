package com.meatz.meatzdriverandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meatz.meatzdriverandroid.Fragments.DetailsFragment
import com.meatz.meatzdriverandroid.Fragments.OrderListFragment
import com.meatz.meatzdriverandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.container,OrderListFragment()).commit()
    }

}