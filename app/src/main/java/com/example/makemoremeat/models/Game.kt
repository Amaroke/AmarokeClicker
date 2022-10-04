package com.example.makemoremeat.models

import android.content.Context
import com.example.makemoremeat.PropertyChangeAware
import com.example.makemoremeat.R
import com.example.makemoremeat.backups.GameBackup
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Game : PropertyChangeAware() {

    private val observer = { property: KProperty<*>,
                             oldValue: Any,
                             newValue: Any ->
        propertyChangeSupport.firePropertyChange(property.name, oldValue, newValue)
    }

    var money: Double by Delegates.observable(0.0, observer)
    var moneyPerSecond = 0
    var fastUP = 1 // 1 = x1, 2 = x10, 3 = x25, 4 = xMax
    var productions: MutableList<Production> = mutableListOf()
    private var butchers: Array<Butcher> = emptyArray()

    init {
        createNewProduction()
    }

    private fun createNewProduction() {

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

        for (i in (0..12)) {
            val production = Production(
                if (i == 0) 1.0 else 0.0,
                (i + 1).toDouble(),
                (i + 1).toDouble(),
                i + 1.0,
                imgArray[i],
                this
            )
            this.productions += production
        }
    }

    fun addButcher(butcher: Butcher) {
        butchers.plus(butcher)
    }

    fun hardReset() {
        money = 0.0
    }

    fun backup(context: Context) {
        val gameBackup = GameBackup(context, money, fastUP)
        gameBackup.saveObjectToSharedPreference(context, "preferences", "game", gameBackup)
    }

    fun restore(context: Context) {
        val gameBackup = GameBackup(context)
        gameBackup.getSavedObjectFromPreference(
            context,
            "preferences",
            "game",
            GameBackup::class.java
        )
        money = gameBackup.money
        fastUP = gameBackup.fastUP
    }

}