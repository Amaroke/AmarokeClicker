package com.example.makemoremeat.production

import com.example.makemoremeat.Jeu

class ModelProduction(
    initialNumber: Int,
    initialCost: Long,
    initialProduction: Long,
    initialProductionTime: Int,
    val image: Int,
    private val jeu: Jeu
) {

    var actualCost = initialCost
    var actualProduction = initialProduction
    var actualProductionTime = initialProductionTime
    var numberPossessed = initialNumber

    fun upgradeProduction() {
        numberPossessed++
        actualProduction++
        actualCost++
        if (numberPossessed % 10 == 0) {
            actualProductionTime /= 2
        }
        jeu.money -= actualCost
    }
}