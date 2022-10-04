package com.example.makemoremeat.activities

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.makemoremeat.R
import com.example.makemoremeat.controllers.ControllerFooter
import com.example.makemoremeat.controllers.ControllerHeader
import com.example.makemoremeat.controllers.ControllerProduction
import com.example.makemoremeat.models.Game

class GameActivity : AppCompatActivity() {

    private var game = Game()

    //Views
    private lateinit var viewHeader: View
    private lateinit var viewsProduction: Sequence<View>
    private lateinit var viewFooter: View

    //Controllers
    private lateinit var controllerHeader: ControllerHeader
    private var controllersProduction: MutableList<ControllerProduction> = mutableListOf()
    private lateinit var controllerFooter: ControllerFooter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //We remove the notification bar and the title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION") window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        this.setContentView(R.layout.activity_main)

        //We restore the game as saved in the SharedPreferences
        game.restore(this)

        viewHeader = this.findViewById(R.id.header)
        controllerHeader = ControllerHeader(game, viewHeader)

        viewsProduction = this.findViewById<LinearLayout>(R.id.productionsList).children

        for ((index, value) in viewsProduction.withIndex()) {
            controllersProduction += ControllerProduction(
                this, game, value, game.productions[index]
            )
        }

        viewFooter = this.findViewById(R.id.footer)
        controllerFooter = ControllerFooter(this, viewFooter)

        game.addPropertyChangeListener {
            controllerHeader.refresh()
            for (controller in controllersProduction) {
                controller.refresh()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        game.backup(this)
    }

}




