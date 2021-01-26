package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val intentResult = intent.getStringArrayExtra(KEY_3)
        val toss = intentResult!![2]
        val playerTotalScore = if(toss == "Bowling") intentResult!![1] else intentResult!![0]
        val cpuTotalScore = if(toss == "Bowling") intentResult!![0] else intentResult!![1]

        playerTotalScoreTextView.text = playerTotalScore
        cpuTotalScoreTextView.text = cpuTotalScore

        val matchResult = if(playerTotalScore.toInt() == cpuTotalScore.toInt()) "Wow $playerName! The match is DRAW"
        else if(playerTotalScore.toInt() < cpuTotalScore.toInt()) "Sorry $playerName! You LOST"
        else "Congrats $playerName! You WON"

        matchResultTextView.text = matchResult

        mainMenuButton.setOnClickListener {
            val i = Intent(this , MainActivity::class.java)
            startActivity(i)
        }
    }
}