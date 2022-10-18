package com.example.makemoremeat.controllers

import android.app.Activity
import android.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.makemoremeat.R
import com.example.makemoremeat.enumerations.FastUP
import com.example.makemoremeat.models.Game
import com.example.makemoremeat.tools.NumberFormatter

class ControllerHeader(
    private val context: Activity,
    private val game: Game,
    private val viewHeader: View
) {

    private var money: TextView = viewHeader.findViewById(R.id.textViewMoney)
    private var buttonsList: Array<Button> = arrayOf(
        viewHeader.findViewById(R.id.buttonX1),
        viewHeader.findViewById(R.id.buttonX10),
        viewHeader.findViewById(R.id.buttonX25),
        viewHeader.findViewById(R.id.buttonXMax)
    )
    private var settings: ImageButton = viewHeader.findViewById(R.id.imageButtonSettings)

    init {
        buttonsListenerInitialisation()
        settings.setOnClickListener {
            hardReset()
            refresh()
        }
        refresh()
    }

    private fun buttonsListenerInitialisation() {
        for ((index, button) in buttonsList.withIndex()) {
            button.setOnClickListener {
                this.game.fastUP = FastUP.values()[index]
                refresh()
            }
        }
    }

    private fun hardReset() {
        val builder = AlertDialog.Builder(viewHeader.context)
        builder.setMessage("Are you sure you want to Reset?").setCancelable(true)
            .setPositiveButton("Yes") { _, _ ->
                game.hardReset()
            }.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }

    fun refresh() {
        val formatter = NumberFormatter()
        money.text = formatter.getFormattedNumber(game.money)
        refreshButtons()
    }

    private fun refreshButtons() {
        for (button in buttonsList) {
            button.isClickable = true
            button.setTextColor(ContextCompat.getColor(context, R.color.whiteOFF))
        }
        when (game.fastUP) {
            FastUP.X10 -> {
                buttonsList[1].isClickable = false
                buttonsList[1].setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            FastUP.X25 -> {
                buttonsList[2].isClickable = false
                buttonsList[2].setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            FastUP.XMax -> {
                buttonsList[3].isClickable = false
                buttonsList[3].setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            else -> {
                buttonsList[0].isClickable = false
                buttonsList[0].setTextColor(ContextCompat.getColor(context, R.color.white))
            }
        }
    }
}