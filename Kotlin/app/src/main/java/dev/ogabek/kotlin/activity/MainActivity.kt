package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.fragment.FirstFragment
import dev.ogabek.kotlin.fragment.SecondFragment
import dev.ogabek.kotlin.listener.FirstListener
import dev.ogabek.kotlin.listener.SecondListener

class MainActivity : AppCompatActivity(), FirstListener, SecondListener {

    private lateinit var first: FirstFragment
    private lateinit var second: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        first = FirstFragment()
        second = SecondFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.firstFragment, first)
            .replace(R.id.secondFragment, second)
            .commit()

    }

    override fun onFirstSend(string: String) {
        second.updateData(string)
    }

    override fun onSecondSend(string: String) {
        first.updateData(string)
    }

}