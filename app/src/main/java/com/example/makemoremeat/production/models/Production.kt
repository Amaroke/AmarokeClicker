package com.example.makemoremeat.production.models

abstract class Production(initialCost: Int, initialProduction: Int, initialProductionTime: Int, val image: Int) {
    abstract fun upgradeProduction()

    var actualCost = initialCost
    var actualProduction = initialProduction
    var actualProductionTime = initialProductionTime
    var numberPossessed = 0

}