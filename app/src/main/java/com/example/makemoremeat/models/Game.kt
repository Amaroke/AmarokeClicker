package com.example.makemoremeat.models

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.makemoremeat.tools.PropertyChangeAware
import com.example.makemoremeat.R
import com.example.makemoremeat.enumerations.FastUP
import com.example.makemoremeat.enumerations.ProductionInformation
import com.example.makemoremeat.tools.DbConstants
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Game : PropertyChangeAware(){

    private val observer = { property: KProperty<*>,
                             oldValue: Any,
                             newValue: Any ->
        propertyChangeSupport.firePropertyChange(property.name, oldValue, newValue)
    }

    var money: Double by Delegates.observable(0.0, observer)
    var moneyPerSecond = 0
    var fastUP = FastUP.X1
    var productions: MutableList<Production> = mutableListOf()
    private var butchers: Array<Butcher> = emptyArray()

    init {
        createNewProduction()
    }

    private fun createNewProduction() {
        productions.clear()

        val imgArray = intArrayOf(
            R.drawable.chicken,
            R.drawable.beef,
            R.drawable.mutton,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork,
            R.drawable.pork
        )

        for (i in 0 until DbConstants.PRODUCTION_NUMBER) {
            val production = Production(
                imgArray[i],
                this,
                ProductionInformation.values()[i]
            )
            this.productions += production
        }
    }

    fun addButcher(butcher: Butcher) {
        butchers.plus(butcher)
    }

    fun hardReset() {
        money = 0.0
        createNewProduction()
    }

    fun backup(context: Context) {
        context.getSharedPreferences("game", MODE_PRIVATE).edit().putString("money", money.toString()).apply()
        for(production in productions){
            production.backup(context)
        }
    }

    fun restore(context: Context) {
        money = context.getSharedPreferences("game", MODE_PRIVATE).getString("money", "0")?.toDouble()
            ?: 0.0
        for (production in productions) {
            production.restore(context)
        }
    }

}