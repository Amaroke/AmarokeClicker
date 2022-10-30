package com.example.makemoremeat.activities

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.makemoremeat.R
import com.example.makemoremeat.controllers.ControllerFooter
import com.example.makemoremeat.controllers.ControllerHeader
import com.example.makemoremeat.controllers.ControllerProduction
import com.example.makemoremeat.models.Game

class GameActivity : AppCompatActivity() {

    // Model
    private var game = Game()

    // Views
    private lateinit var viewHeader: View
    private lateinit var viewsProduction: Sequence<View>
    private lateinit var viewFooter: View

    // Controllers
    private lateinit var controllerHeader: ControllerHeader
    private var controllersProduction: MutableList<ControllerProduction> = mutableListOf()
    private lateinit var controllerFooter: ControllerFooter

    // Butchers menu
    private lateinit var dialogButchers: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
        game.restore(this)
        butcherMenuCreation()
        createHeaderFooter()

        viewsProduction = this.findViewById<LinearLayout>(R.id.productionsList).children
        // We associate ControllerProduction to each Production
        for ((index, value) in viewsProduction.withIndex()) {
            controllersProduction += ControllerProduction(
                this, game, value, game.productions[index]
            )
        }

        game.addPropertyChangeListener {
            refresh()
            game.backup(this)
        }

    }

    override fun onStop() {
        super.onStop()
        game.backup(this)
    }

    private fun createHeaderFooter() {
        viewHeader = this.findViewById(R.id.header)
        controllerHeader = ControllerHeader(this, game, viewHeader)

        viewFooter = this.findViewById(R.id.footer)
        controllerFooter = ControllerFooter(this, viewFooter)
    }

    private fun butcherMenuCreation() {
        dialogButchers = Dialog(this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
        dialogButchers.setContentView(R.layout.butcher)
    }

    fun showDialogButchers() {
        dialogButchers.show()
    }

    private fun refresh() {
        controllerHeader.refresh()
        for (controller in controllersProduction) {
            controller.refresh()
        }
    }

}




