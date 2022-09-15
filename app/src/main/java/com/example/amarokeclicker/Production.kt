package com.example.amarokeclicker

abstract class Production(initialCost: Int, initialProduction: Int, initialProductionTime: Int) {

    var actualCost = initialCost
    var actualProduction = initialProduction
    var actualProductionTime = initialProductionTime
    var numberPossessed = 0

}