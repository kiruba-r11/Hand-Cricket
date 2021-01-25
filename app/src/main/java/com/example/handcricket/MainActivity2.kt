package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

val KEY_2 = "toss"

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        batButton.setOnClickListener {
            callIntent("Batting")
        }

        bowlButton.setOnClickListener {
            callIntent("Bowling")
        }

    }

    fun callIntent(toss: String) {
        val i = Intent(this , MainActivity3::class.java)
        i.putExtra(KEY_2 , toss)
        startActivity(i)
    }
}