package com.example.amarokeclicker

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var jeu = Jeu()

    //Views
    private lateinit var viewHeader: View
    private lateinit var viewChicken: View
    private lateinit var viewCow: View
    private lateinit var viewSheep: View
    private lateinit var viewPig: View
    private lateinit var viewRabbit: View
    private lateinit var viewHorse: View
    private lateinit var viewCaribou: View
    private lateinit var viewFish: View
    private lateinit var viewDog: View
    private lateinit var viewElephant: View
    private lateinit var viewBugs: View
    private lateinit var viewVegan: View
    private lateinit var viewCultured: View
    private lateinit var viewFooter: View

    //Controllers
    private lateinit var controllerChicken: ControllerChicken
    private lateinit var controllerHeader: ControllerHeader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Retrait de la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.supportActionBar?.hide()
        this.setContentView(R.layout.activity_main)

        jeu.addPropertyChangeListener {
            controllerHeader.refresh()
        }

        //On récupère les vues
        viewHeader = this.findViewById(R.id.header)
        viewChicken = this.findViewById(R.id.chicken)
        viewCow = this.findViewById(R.id.cow)
        viewSheep = this.findViewById(R.id.sheep)
        viewPig = this.findViewById(R.id.pig)
        viewRabbit = this.findViewById(R.id.rabbit)
        viewHorse = this.findViewById(R.id.horse)
        viewCaribou = this.findViewById(R.id.caribou)
        viewFish = this.findViewById(R.id.fish)
        viewDog = this.findViewById(R.id.dog)
        viewElephant = this.findViewById(R.id.elephant)
        viewBugs = this.findViewById(R.id.bugs)
        viewVegan = this.findViewById(R.id.vegan)
        viewCultured = this.findViewById(R.id.cultured)
        viewFooter = this.findViewById(R.id.footer)

        controllerChicken = ControllerChicken(jeu, viewChicken, Chicken())
        controllerHeader = ControllerHeader(jeu, viewHeader)
    }

}