package com.example.makemoremeat.models

class Production(
    initialNumber: Double,
    initialCost: Double,
    initialProduction: Double,
    initialProductionTime: Double,
    val image: Int,
    private val game: Game
) {

    var actualCost = initialCost
    var actualProduction = initialProduction
    var actualProductionTime = initialProductionTime
    var numberPossessed = initialNumber

    fun upgradeProduction() {
        game.money -= actualCost.toLong()
        numberPossessed++
        actualProduction++
        actualCost++
        if (numberPossessed % 10 == 0.0) {
            actualProductionTime /= 2
        }
    }
}