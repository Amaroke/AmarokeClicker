package com.example.amarokeclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var coinCounter = 0
    private var nb1 = 1
    private var coutnb1 = 10;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onScreenClick(v: View) {
        coinCounter += nb1
        this.findViewById<TextView>(R.id.coins).text = coinCounter.toString()
    }

    fun onClicknb1(v : View) {
        if(coinCounter>coutnb1) {
            coinCounter-=coutnb1
            nb1++
            this.findViewById<TextView>(R.id.coins).text = coinCounter.toString()
            this.findViewById<TextView>(R.id.textView2).text = "cout :" + coutnb1.toString()
            this.findViewById<TextView>(R.id.nbameliotext).text = "nb amelio : " + nb1.toString()
            coutnb1+=10


        }

    }
}