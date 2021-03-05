package com.github.repositories.ui.home.view

import android.os.Bundle
import com.github.repositories.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showHomeFragment()
    }

    private fun showHomeFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .add(R.id.container, HomeFragment())
        fragmentTransaction.commit()
    }
}
