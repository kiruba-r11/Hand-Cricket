package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val intentResult = intent.getStringArrayExtra(KEY_3)
        val totalScores = intentResult!![0]
        totalScore.text = totalScores
        target.text = (totalScores.toInt() + 1).toString()

        val toss = intentResult!![1]
        val score: Int
        message.text = if(toss == "Batting") {
            "You need to defend $totalScores run" + if(totalScores.toInt() != 1) "s" else ""
        }
        else {
            "You need to chase ${target.text} run" + if(target.text.toString().toInt() != 1) "s" else ""
        }

        next.setOnClickListener {
            val i = Intent(this , MainActivity8::class.java)
            i.putExtra(KEY_3 , arrayOf(if(toss == "Batting") "Bowling" else "Batting" , target.text.toString()))
            startActivity(i)
        }
    }
}