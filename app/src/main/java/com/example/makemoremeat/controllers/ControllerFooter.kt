package com.example.makemoremeat.controllers

import android.app.Activity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.makemoremeat.models.Game
import com.example.makemoremeat.R

class ControllerFooter(context: Activity, private val game: Game, viewHeader: View) {


    init{
        val languages = context.resources.getStringArray(R.array.menuSpinner)

        val spinner: Spinner = viewHeader.findViewById(R.id.spinner)
        val adapter = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_item, languages
        )
        spinner.adapter = adapter
    }

}