package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main3.*

val KEY_3 = "totalScoreAndToss"

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val toss = intent.getStringExtra(KEY_2)
        textView1.text = toss

        val arrayOfButtons = arrayOf(button1 , button2 , button3 , button4 , button5 , button6)

        button1.setOnClickListener{
            updateScore(1 , toss!! , arrayOfButtons)
        }
        button2.setOnClickListener{
            updateScore(2 , toss!! , arrayOfButtons)
        }
        button3.setOnClickListener{
            updateScore(3 , toss!! , arrayOfButtons)
        }
        button4.setOnClickListener{
            updateScore(4 , toss!! , arrayOfButtons)
        }
        button5.setOnClickListener{
            updateScore(5 , toss!! , arrayOfButtons)
        }
        button6.setOnClickListener{
            updateScore(6 , toss!! , arrayOfButtons)
        }

        nextButton.setOnClickListener {
            val i = Intent(this , MainActivity4::class.java)
            val totalScoreAndToss = arrayOf(totalScoreTextView.text.toString() , toss)
            i.putExtra(KEY_3 , totalScoreAndToss)
            startActivity(i)
        }

    }

    fun updateScore(currentPlayerValue: Int , toss: String , arrayOfButtons: Array <MaterialButton>) {
        var currentCPUValue = Random.nextInt(1 , 7)
        var toastMessage = if(toss == "Batting") "You are OUT!" else "CPU is OUT!"
        playerTextView.text = currentPlayerValue.toString()
        cpuTextView.text = currentCPUValue.toString()
        if(currentCPUValue == currentPlayerValue) {
            disableButtons(arrayOfButtons)
            Toast.makeText(this , toastMessage , Toast.LENGTH_SHORT).show()
            nextButton.visibility = View.VISIBLE
        }
        else {
            totalScoreTextView.text = if(toss == "Batting")
            (totalScoreTextView.text.toString().toInt() + currentPlayerValue).toString()
            else (totalScoreTextView.text.toString().toInt() + currentCPUValue).toString()
        }
    }

    fun disableButtons(arrayOfButtons: Array <MaterialButton>) {
        for(i in 0 until 6) {
            arrayOfButtons[i].isEnabled = false
        }
    }
}