package com.example.amarokeclicker

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var viewCoins: TextView
    private lateinit var production1: ImageButton
    private lateinit var buypoulet: Button
    private var progressBarStatus = 0
    private var coins = 0
    private var chicken = Chicken()
    private lateinit var viewChicken: View
    private lateinit var viewHeader: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrait de la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.supportActionBar?.hide()
        //On définit le contenu de la vue APRES les instructions précédentes pour éviter un crash
        this.setContentView(R.layout.activity_main)

        viewChicken = this.findViewById(R.id.chicken)
        viewHeader = this.findViewById(R.id.header)

        progressBar = viewChicken.findViewById(R.id.progressBarProduction)
        viewCoins = viewHeader.findViewById(R.id.textViewMoney)

       production1 = viewChicken.findViewById(R.id.imageButtonProduction)
       production1.setOnClickListener {

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
       buypoulet = viewChicken.findViewById(R.id.buttonUpgradeProduction)


       refreshView()
    }

    private fun refreshView() {
        viewCoins.text = coins.toString()
    }
}