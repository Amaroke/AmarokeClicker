package com.example.makemoremeat.production

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import com.example.makemoremeat.Jeu
import com.example.makemoremeat.R

class ControllerProduction(
    private val context: Context,
    jeu: Jeu,
    view: View,
    private val production: ModelProduction
) {

    private var startProduction: ImageButton = view.findViewById(R.id.imageButtonProduction)
    private var possesses: TextView = view.findViewById(R.id.textViewPossesses)
    private var progressBarProduction: ProgressBar =
        view.findViewById(R.id.progressBarProduction)
    private var textProduction: TextView = view.findViewById(R.id.textViewProduction)
    private var upgradeProduction: Button = view.findViewById(R.id.buttonUpgradeProduction)
    private var upgradeCostProduction: TextView =
        view.findViewById(R.id.textViewUpgradeCostProduction)
    private var timeLeftProduction: TextView = view.findViewById(R.id.textViewTime)
    private var progressBarStatus = 0
    private var timeStop: Long = 0

    init {
        startProduction.setBackgroundResource(production.image)

        startProduction.setOnClickListener {
            timeStop = System.currentTimeMillis() + production.actualProductionTime * 100
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

        val milliseconds = timeStop - System.currentTimeMillis()
        val hours = milliseconds / 1000 / 3600
        val minutes = milliseconds / 1000 / 60 % 60
        val seconds = milliseconds / 1000 % 60
        if (hours > 0)
            timeLeftProduction.text = context.getString(R.string.time, hours, minutes, seconds)
        else
            timeLeftProduction.text = context.getString(R.string.timeNoHours, minutes, seconds)
    }

}