package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main8.*
import kotlin.random.Random

class MainActivity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)


        val intentResult = intent.getStringArrayExtra(KEY_3)
        val toss = intentResult!![0]
        textView1.text = toss
        val target = intentResult!![1].toInt()

        val arrayOfButtons = arrayOf(Button1 , Button2 , Button3 , Button4 , Button5 , Button6)

        Button1.setOnClickListener{
            updateScore(1 , toss!! , arrayOfButtons , target)
        }
        Button2.setOnClickListener{
            updateScore(2 , toss!! , arrayOfButtons , target)
        }
        Button3.setOnClickListener{
            updateScore(3 , toss!! , arrayOfButtons , target)
        }
        Button4.setOnClickListener{
            updateScore(4 , toss!! , arrayOfButtons , target)
        }
        Button5.setOnClickListener{
            updateScore(5 , toss!! , arrayOfButtons , target)
        }
        Button6.setOnClickListener{
            updateScore(6 , toss!! , arrayOfButtons , target)
        }

        nextButton1.setOnClickListener {
            val i = Intent(this , MainActivity5::class.java)
            val totalScoresAndToss = arrayOf(totalScoreTextView1.text.toString() , (target - 1).toString() , toss)
            i.putExtra(KEY_3 , totalScoresAndToss)
            startActivity(i)
        }

    }

    fun updateScore(currentPlayerValue: Int , toss: String , arrayOfButtons: Array <MaterialButton> , target: Int) {
        var currentCPUValue = Random.nextInt(1 , 7)
        var toastMessage = if(toss == "Batting") "You are OUT!" else "CPU is OUT!"
        playerTextView1.text = currentPlayerValue.toString()
        cpuTextView1.text = currentCPUValue.toString()
        if(currentCPUValue == currentPlayerValue) {
            disableButtons(arrayOfButtons)
            Toast.makeText(this , toastMessage , Toast.LENGTH_SHORT).show()
            nextButton1.visibility = View.VISIBLE
        }
        else {
            totalScoreTextView1.text = if(toss == "Batting")
                (totalScoreTextView1.text.toString().toInt() + currentPlayerValue).toString()
            else (totalScoreTextView1.text.toString().toInt() + currentCPUValue).toString()
        }
        if(totalScoreTextView1.text.toString().toInt() >= target) {
            disableButtons(arrayOfButtons)
            Toast.makeText(this, "GAME OVER", Toast.LENGTH_SHORT).show()
            nextButton1.visibility = View.VISIBLE
        }
    }

    fun disableButtons(arrayOfButtons: Array <MaterialButton>) {
        for(i in 0 until 6) {
            arrayOfButtons[i].isEnabled = false
        }
    }
}