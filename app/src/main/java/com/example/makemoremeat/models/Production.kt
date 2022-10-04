package com.example.makemoremeat.models

import android.content.Context
import com.example.makemoremeat.enumerations.ProductionInformation
import kotlin.math.pow

class Production (
    val image: Int,
    private val game: Game,
    private val productionInformation: ProductionInformation
) {

    var numberPossessed = productionInformation.initialNumber
    var actualCost = productionInformation.initialCost * 1.15.pow(numberPossessed)
    var actualProduction = productionInformation.initialProduction
    var actualProductionTime = productionInformation.initialProductionTime


    fun upgradeProduction() {
        game.money -= actualCost.toLong()
        numberPossessed++
        actualProduction++
        actualCost = productionInformation.initialCost * 1.15.pow(numberPossessed)
        if (numberPossessed % 10 == 0.0) {
            actualProductionTime /= 2
        }
    }

    fun backup(context: Context) {
        context.getSharedPreferences(productionInformation.toString(), Context.MODE_PRIVATE).edit().putString("numberPossessed", numberPossessed.toString()).apply()
    }

    fun restore(context: Context) {
        numberPossessed = context.getSharedPreferences(productionInformation.toString(), Context.MODE_PRIVATE).getString("numberPossessed", if (productionInformation==ProductionInformation.Chicken) "1" else "0")?.toDouble()
            ?: if(productionInformation == ProductionInformation.Chicken) 1.0 else 0.0
        actualCost = productionInformation.initialCost * 1.15.pow(numberPossessed)
    }
}