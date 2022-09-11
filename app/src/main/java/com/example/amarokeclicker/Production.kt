package com.example.amarokeclicker

abstract class Production(initialCost: Int, initialProduction: Int, initialProductionTime: Int) {

    var actualCost: Int = initialCost
    var actualProduction: Int = initialProduction
    var actualProductionTime: Int = initialProductionTime

}