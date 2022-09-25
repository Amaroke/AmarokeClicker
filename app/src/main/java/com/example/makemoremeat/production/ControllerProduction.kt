package com.example.makemoremeat.production

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import com.example.makemoremeat.Jeu
import com.example.makemoremeat.R

class ControllerProduction(private val context: Context, jeu: Jeu, viewChicken: View, private val production: ModelProduction) {

    private var startProduction: ImageButton = viewChicken.findViewById(R.id.imageButtonProduction)
    private var possesses: TextView = viewChicken.findViewById(R.id.textViewPossesses)
    private var progressBarProduction: ProgressBar =
        viewChicken.findViewById(R.id.progressBarProduction)
    private var textProduction: TextView = viewChicken.findViewById(R.id.textViewProduction)
    private var upgradeProduction: Button = viewChicken.findViewById(R.id.buttonUpgradeProduction)
    private var upgradeCostProduction: TextView =
        viewChicken.findViewById(R.id.textViewUpgradeCostProduction)

    private var progressBarStatus = 0

    init {
        startProduction.setBackgroundResource(production.image)

        startProduction.setOnClickListener {

            startProduction.isClickable = false
            Thread {

                while (progressBarStatus < 100) {

                    try {
                        progressBarStatus += 1
                        Thread.sleep(production.actualProductionTime.toLong())
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    progressBarProduction.progress = progressBarStatus

                }

                progressBarStatus = 0
                progressBarProduction.progress = progressBarStatus
                jeu.money += production.actualProduction
                startProduction.isClickable = true

            }.start()
        }

        upgradeProduction.setOnClickListener {
            production.upgradeProduction()
            refresh()
        }

        refresh()

    }

    private fun refresh() {
        possesses.text = production.numberPossessed.toString()
        textProduction.text = production.actualProduction.toString()
        upgradeCostProduction.text = context.getString(R.string.costValue, production.actualCost)
    }

}