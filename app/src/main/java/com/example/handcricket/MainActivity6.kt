package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        playButton.setOnClickListener {

            val i = Intent(this , MainActivity2::class.java)
            startActivity(i)
        }

        rulesButton.setOnClickListener {
            val i = Intent(this , MainActivity7::class.java)
            startActivity(i)
        }
    }
}