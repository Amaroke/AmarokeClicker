package com.example.makemoremeat

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.makemoremeat.production.ControllerProduction
import com.example.makemoremeat.production.ModelProduction

class MainActivity : AppCompatActivity() {

    private var jeu = Jeu()

    //Views
    private lateinit var viewHeader: View
    private lateinit var viewsProduction: Sequence<View>
    private lateinit var viewFooter: View

    //Controllers
    private lateinit var controllerHeader: ControllerHeader
    private var controllersProduction: MutableList<ControllerProduction> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        this.setContentView(R.layout.activity_main)


        viewHeader = this.findViewById(R.id.header)
        controllerHeader = ControllerHeader(jeu, viewHeader)

        viewsProduction = this.findViewById<LinearLayout>(R.id.productionsList).children
        val imgArray = intArrayOf(
            R.drawable.chicken,
            R.drawable.beef,
            R.drawable.mutton,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork
        )

        for ((index, value) in viewsProduction.withIndex()) {
            controllersProduction += ControllerProduction(
                this,
                jeu,
                value,
                ModelProduction(
                    if (index == 0) 1 else 0,
                    (index + 1).toLong(),
                    (index + 1).toLong(),
                    index + 1,
                    imgArray[index], jeu
                )
            )
        }

        viewFooter = this.findViewById(R.id.footer)

        jeu.addPropertyChangeListener {
            controllerHeader.refresh()
            for (controller in controllersProduction) {
                controller.refresh()
            }
        }
    }


}




