package com.fire.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fire.chat.fragment.AccountFragment
import com.fire.chat.fragment.PeopleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(PeopleFragment())

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_people -> {
                    replaceFragment(PeopleFragment())
                    true
                }
                R.id.navigation_my_account -> {
                    replaceFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_layout, fragment)
                .commit()
    }
}
