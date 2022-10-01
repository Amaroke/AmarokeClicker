package com.example.makemoremeat.models

class Production(
    initialNumber: Int,
    initialCost: Long,
    initialProduction: Long,
    initialProductionTime: Int,
    val image: Int,
    private val game: Game
) {

    var actualCost = initialCost
    var actualProduction = initialProduction
    var actualProductionTime = initialProductionTime
    var numberPossessed = initialNumber

    fun upgradeProduction() {
        game.money -= actualCost
        numberPossessed++
        actualProduction++
        actualCost++
        if (numberPossessed % 10 == 0) {
            actualProductionTime /= 2
        }
    }
}