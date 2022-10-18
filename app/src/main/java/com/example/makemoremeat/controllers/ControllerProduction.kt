package com.example.makemoremeat.controllers

import android.app.Activity
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import com.example.makemoremeat.R
import com.example.makemoremeat.models.Game
import com.example.makemoremeat.models.Production
import com.example.makemoremeat.tools.NumberFormatter

class ControllerProduction(
    private val context: Activity,
    private val game: Game,
    view: View,
    private val production: Production
) {

    private var startProduction: ImageButton = view.findViewById(R.id.imageButtonProduction)
    private var possesses: TextView = view.findViewById(R.id.textViewPossesses)
    private var progressBarProduction: ProgressBar = view.findViewById(R.id.progressBarProduction)
    private var textProduction: TextView = view.findViewById(R.id.textViewProduction)
    private var upgradeProduction: Button = view.findViewById(R.id.buttonUpgradeProduction)
    private var upgradeCostProduction: TextView =
        view.findViewById(R.id.textViewUpgradeCostProduction)
    private var timeLeftProduction: TextView = view.findViewById(R.id.textViewTime)

    private var productionOn: Boolean = false
    private var butcher = true
    private var timer: CountDownTimer

    private var formatter = NumberFormatter()

    init {
        setBackgroundImage()

        timeLeftProduction.text = context.getString(R.string.timeNoHours, 0, 0)
        setTimerOff()

        startProduction.setOnClickListener {
            startProduction()
        }

        upgradeProduction.setOnClickListener {
            upgradeProduction()
        }

        timer = object : CountDownTimer(
            (production.actualProductionTime / 10).toLong(), 100
        ) {

            override fun onTick(millisUntilFinished: Long) {
                val hours = millisUntilFinished / 1000 / 3600
                val minutes = millisUntilFinished / 1000 / 60 % 60
                val seconds = millisUntilFinished / 1000 % 60
                if (hours > 0) timeLeftProduction.text =
                    context.getString(R.string.time, hours, minutes, seconds)
                else timeLeftProduction.text =
                    context.getString(R.string.timeNoHours, minutes, seconds)
            }

            override fun onFinish() {
                timeLeftProduction.text = context.getString(R.string.timeNoHours, 0, 0)
                setTimerOff()
            }
        }

        refresh()
    }

    fun refresh() {
        context.runOnUiThread {

            possesses.text = String.format("%.0f", production.numberPossessed)

            setBackgroundImage()

            refreshProgressBar()

            upgradeCostProduction.text =
                context.getString(
                    R.string.cost,
                    formatter.getFormattedNumber(production.actualCost)
                )

            refreshButtonsUpgrade()

            refreshButtonsStart()

        }
    }

    private fun refreshProgressBar() {
        // If the butcher exists and the production is fast, the display is in money/second
        if (butcher && production.actualProductionTime <= 1000) {
            textProduction.text = context.getString(
                R.string.productionPerSecond,
                formatter.getFormattedNumber(production.actualProduction / production.actualProductionTime * 100)
            )
            // And we remove the timer
            timeLeftProduction.isInvisible = true
        } else {
            textProduction.text = formatter.getFormattedNumber(production.actualProduction)
        }
    }

    private fun setBackgroundImage() {
        if (production.numberPossessed > 0) {
            startProduction.setBackgroundResource(production.image)
        } else {
            startProduction.setBackgroundResource(R.drawable.production_unknow)
        }
    }

    private fun setTimerOn() {
        timeLeftProduction.setTextColor(ContextCompat.getColor(context, R.color.white))
    }

    private fun setTimerOff() {
        timeLeftProduction.setTextColor(ContextCompat.getColor(context, R.color.whiteOFF))
    }

    private fun refreshButtonsUpgrade() {
        if (production.actualCost > game.money) {
            upgradeProduction.isClickable = false
            upgradeProduction.isEnabled = false
            upgradeProduction.setBackgroundColor(ContextCompat.getColor(context, R.color.gris2))
        } else {
            upgradeProduction.isClickable = true
            upgradeProduction.isEnabled = true
            upgradeProduction.setBackgroundColor(ContextCompat.getColor(context, R.color.gris3))
        }

    }

    private fun refreshButtonsStart() {
        if (production.numberPossessed > 0 && !productionOn) {
            startProduction.isClickable = true
            startProduction.isEnabled = true
        } else {
            startProduction.isClickable = false
            startProduction.isEnabled = false
        }

    }

    private fun upgradeProduction() {
        if (game.money >= production.actualCost) {
            production.upgradeProduction()
        }
    }

    private fun startTimerProduction() {
        setTimerOn()
        if (production.actualProductionTime > 1000) {
            timer.cancel()
            timer.start()
        }
    }

    private fun startProduction() {
        if (production.numberPossessed > 0 && !productionOn) {
            progressBarProduction.progress = 0
            productionOn = true
            startTimerProduction()


            if (production.actualProductionTime <= 1000 && butcher) {
                progressBarProduction.progress = 100
                Thread {
                    while (true) {
                        val productionPerSecond =
                            production.actualProduction * production.actualProductionTime / 10000
                        Thread.sleep(100)
                        game.money += productionPerSecond
                    }
                }.start()

            } else {
                progressBarProduction.progress = 0

                Thread {

                    while (progressBarProduction.progress < 100) {
                        progressBarProduction.progress += 1
                        Thread.sleep(production.actualProductionTime.toLong() / 1000)
                    }

                    progressBarProduction.progress = 0
                    game.money += production.actualProduction
                    productionOn = false
                    if (butcher) {
                        startProduction()
                    }
                }.start()
            }
        }
    }

}