package com.example.makemoremeat

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.makemoremeat.production.ControllerProduction
import com.example.makemoremeat.production.ModelProduction
import kotlin.math.pow

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
        //Removing the title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.supportActionBar?.hide()
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
                    10.0.pow((index + 1).toDouble()).toLong(),
                    (1..index).fold(1, Int::times).toLong(),
                    3.0.pow((if (index < 3) index else index - 1).toDouble()).toInt(),
                    imgArray[index]
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




