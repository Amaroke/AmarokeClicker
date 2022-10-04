package com.example.makemoremeat.models

import android.content.Context
import com.example.makemoremeat.enumerations.ProductionNames

class Production (
    initialNumber: Double,
    initialCost: Double,
    initialProduction: Double,
    initialProductionTime: Double,
    val image: Int,
    private val game: Game,
    private val name: ProductionNames
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

    fun backup(context: Context) {
        context.getSharedPreferences(name.toString(), Context.MODE_PRIVATE).edit().putString("numberPossessed", numberPossessed.toString()).apply()
    }

    fun restore(context: Context) {
        numberPossessed = context.getSharedPreferences(name.toString(), Context.MODE_PRIVATE).getString("numberPossessed", if (name==ProductionNames.Chicken) "1" else "0")?.toDouble()
            ?: if(name == ProductionNames.Chicken) 1.0 else 0.0
    }
}