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
    private var progressBarStatus = 0
    private var coins = 0
    private var poulet = Poulet()

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
        viewCoins.text = coins.toString()
    }

    fun onClickButton1(v: View) {
        production1.isClickable = false
        Thread {

            while (progressBarStatus < 100) {

                try {
                    progressBarStatus += 1
                    Thread.sleep(poulet.actualProductionTime.toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                progressBar.progress = progressBarStatus

            }

            progressBarStatus = 0
            progressBar.progress = progressBarStatus
            coins += poulet.actualProduction
            viewCoins.text = coins.toString()
            production1.isClickable = true

        }.start()
    }
}