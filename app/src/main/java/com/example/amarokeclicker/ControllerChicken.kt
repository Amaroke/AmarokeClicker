package com.example.amarokeclicker

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView

class ControllerChicken(jeu: Jeu, viewChicken: View, private val chicken: Chicken) {

    private var production: ImageButton = viewChicken.findViewById(R.id.imageButtonProduction)
    private var possesses: TextView = viewChicken.findViewById(R.id.textViewPossesses)
    private var progressBarProduction: ProgressBar =
        viewChicken.findViewById(R.id.progressBarProduction)
    private var textProduction: TextView = viewChicken.findViewById(R.id.textViewProduction)
    private var upgradeProduction: Button = viewChicken.findViewById(R.id.buttonUpgradeProduction)
    private var upgradeCostProduction: TextView =
        viewChicken.findViewById(R.id.textViewUpgradeCostProduction)

    private var progressBarStatus = 0

    init {
        production.setBackgroundResource(R.drawable.pataepollo)

        production.setOnClickListener {

            production.isClickable = false
            Thread {

                while (progressBarStatus < 100) {

                    try {
                        progressBarStatus += 1
                        Thread.sleep(chicken.actualProductionTime.toLong())
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    progressBarProduction.progress = progressBarStatus

                }

                progressBarStatus = 0
                progressBarProduction.progress = progressBarStatus
                jeu.money += chicken.actualProduction
                production.isClickable = true

            }.start()
        }

        upgradeProduction.setOnClickListener {
            chicken.upgradeProduction()
            refresh()
        }

        refresh()

    }

    private fun refresh() {
        possesses.text = chicken.numberPossessed.toString()
        textProduction.text = chicken.actualProduction.toString()
        upgradeCostProduction.text = "Coût : " + chicken.actualCost.toString()
    }

}