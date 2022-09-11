package com.example.amarokeclicker

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var viewCoins: TextView
    private lateinit var production1: Button
    private lateinit var buypoulet: Button
    private var progressBarStatus = 0
    private var coins = 0
    private var chicken = Chicken()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrait de la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.supportActionBar?.hide()
        //On définit le contenu de la vue APRES les instructions précédentes pour éviter un crash
        this.setContentView(R.layout.activity_main)
        progressBar = this.findViewById(R.id.progressBar_production1)
        viewCoins = this.findViewById(R.id.textView_coins)
        production1 = this.findViewById(R.id.button_production1)
        buypoulet = this.findViewById(R.id.button_buy1)
        refreshView()
    }

    fun onClickButton1(v: View) {
        production1.isClickable = false
        Thread {

            while (progressBarStatus < 100) {

                try {
                    progressBarStatus += 1
                    Thread.sleep(chicken.actualProductionTime.toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                progressBar.progress = progressBarStatus

            }

            progressBarStatus = 0
            progressBar.progress = progressBarStatus
            coins += chicken.actualProduction
            refreshView()
            production1.isClickable = true

        }.start()
    }

    fun onclickbuypoulet(v : View) {
        if(coins>chicken.actualCost) {
            coins-=chicken.actualCost
            chicken.actualCost+=2
            chicken.actualProduction+=1
            refreshView()
        }

    }

    fun refreshView() {
        viewCoins.text = coins.toString()
    }
}