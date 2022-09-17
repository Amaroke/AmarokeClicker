package com.example.amarokeclicker.production.models

import android.graphics.drawable.Drawable

abstract class Production(initialCost: Int, initialProduction: Int, initialProductionTime: Int, val image: Int) {
    abstract fun upgradeProduction()

    var actualCost = initialCost
    var actualProduction = initialProduction
    var actualProductionTime = initialProductionTime
    var numberPossessed = 0

}