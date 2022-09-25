package com.example.makemoremeat.production

class ModelProduction(
    initialNumber: Int,
    initialCost: Long,
    initialProduction: Long,
    initialProductionTime: Int,
    val image: Int
) {

    var actualCost = initialCost
    var actualProduction = initialProduction
    var actualProductionTime = initialProductionTime
    var numberPossessed = initialNumber

    fun upgradeProduction() {
        numberPossessed++
        actualProduction++
        actualCost += 10
    }
}