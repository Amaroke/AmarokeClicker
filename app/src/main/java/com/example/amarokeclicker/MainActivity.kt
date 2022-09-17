package com.example.amarokeclicker

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.amarokeclicker.production.controllers.ControllerProduction
import com.example.amarokeclicker.production.models.Beef
import com.example.amarokeclicker.production.models.Chicken
import com.example.amarokeclicker.production.models.Mutton
import com.example.amarokeclicker.production.models.Pork

class MainActivity : AppCompatActivity() {

    private var jeu = Jeu()

    //Views
    private lateinit var viewHeader: View
    private lateinit var viewChicken: View
    private lateinit var viewBeef: View
    private lateinit var viewMutton: View
    private lateinit var viewPork: View
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
    private lateinit var controllerProduction: ControllerProduction
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
        viewBeef = this.findViewById(R.id.beef)
        viewMutton = this.findViewById(R.id.mutton)
        viewPork = this.findViewById(R.id.pork)
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

        controllerProduction = ControllerProduction(jeu, viewChicken, Chicken())
        controllerProduction = ControllerProduction(jeu, viewBeef, Beef())
        controllerProduction = ControllerProduction(jeu, viewMutton, Mutton())
        controllerProduction = ControllerProduction(jeu, viewPork, Pork())
        controllerHeader = ControllerHeader(jeu, viewHeader)
    }

}