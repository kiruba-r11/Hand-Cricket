package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

val KEY_1 = "playerName"
var playerName = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            playerName = nameEditText.text.toString()
            if(playerName == "")
                Toast.makeText(this , "Invalid name" , Toast.LENGTH_SHORT).show()
            else {
                val i = Intent(this, MainActivity6::class.java)
                startActivity(i)
            }
        }
    }
}