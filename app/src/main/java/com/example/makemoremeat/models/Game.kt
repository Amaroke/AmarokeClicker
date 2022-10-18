package com.example.makemoremeat.models

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.makemoremeat.enumerations.FastUP
import com.example.makemoremeat.enumerations.ProductionInformation
import com.example.makemoremeat.tools.DbConstants
import com.example.makemoremeat.tools.PropertyChangeAware
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Game : PropertyChangeAware(){

    private val observer = { property: KProperty<*>,
                             oldValue: Any,
                             newValue: Any ->
        propertyChangeSupport.firePropertyChange(property.name, oldValue, newValue)
    }

    var money: Double by Delegates.observable(0.0, observer)
    var fastUP = FastUP.X1
    var productions: MutableList<Production> = mutableListOf()

    init {
        createNewProduction()
    }

    private fun createNewProduction() {
        productions.clear()

        for (i in 0 until DbConstants.PRODUCTION_NUMBER) {
            val production = Production(
                this,
                ProductionInformation.values()[i]
            )
            this.productions += production
        }
    }

    fun hardReset() {
        for(production in productions) {
            production.reset()
        }
        money = 0.0
    }

    fun backup(context: Context) {
        context.getSharedPreferences("game", MODE_PRIVATE).edit().putString("money", money.toString()).apply()
        for(production in productions){
            production.backup(context)
        }
    }

    fun restore(context: Context) {
        for (production in productions) {
            production.restore(context)
        }
        money =
            context.getSharedPreferences("game", MODE_PRIVATE).getString("money", "0")?.toDouble()
                ?: 0.0
    }

}