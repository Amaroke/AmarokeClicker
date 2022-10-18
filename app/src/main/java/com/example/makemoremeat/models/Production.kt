package com.example.makemoremeat.models

import android.content.Context
import com.example.makemoremeat.enumerations.ProductionInformation
import kotlin.math.pow

class Production (
    private val game: Game,
    private val productionInformation: ProductionInformation
) {

    val image = productionInformation.imageProduction
    var numberPossessed = productionInformation.initialNumber
    var actualCost =
        productionInformation.initialCost * productionInformation.coefficientCostUp.pow(
            numberPossessed - 1
        )
    var actualProduction = productionInformation.initialProduction
    var actualProductionTime = productionInformation.initialProductionTime

    fun upgradeProduction() {
        game.money -= actualCost.toLong()
        numberPossessed++
        actualProduction = productionInformation.initialProduction * numberPossessed
        actualCost =
            productionInformation.initialCost * productionInformation.coefficientCostUp.pow(
                numberPossessed - 1
            )
        // Each 50 productions, production time is divided by 2
        if (numberPossessed % 50 == 0.0) {
            actualProductionTime /= 2
        }
    }

    fun backup(context: Context) {
        context.getSharedPreferences(productionInformation.toString(), Context.MODE_PRIVATE).edit().putString("numberPossessed", numberPossessed.toString()).apply()
    }

    fun restore(context: Context) {
        numberPossessed =
            context.getSharedPreferences(productionInformation.toString(), Context.MODE_PRIVATE)
                .getString(
                    "numberPossessed",
                    productionInformation.initialNumber.toString()
                )?.toDouble() ?: productionInformation.initialNumber
        actualCost =
            productionInformation.initialCost * productionInformation.coefficientCostUp.pow(
                numberPossessed - 1
            )
        actualProduction = productionInformation.initialProduction * numberPossessed
        actualProductionTime =
            productionInformation.initialProductionTime / 2.0.pow(numberPossessed / 50)
    }

    fun reset() {
        numberPossessed = productionInformation.initialNumber
        actualCost =
            productionInformation.initialCost * productionInformation.coefficientCostUp.pow(
                numberPossessed - 1
            )
        actualProduction = productionInformation.initialProduction
        actualProductionTime = productionInformation.initialProductionTime
    }
}