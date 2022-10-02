package com.example.makemoremeat.models

import com.example.makemoremeat.PropertyChangeAware
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Game : PropertyChangeAware() {

    private val observer = {
            property: KProperty<*>,
            oldValue: Any,
            newValue: Any -> propertyChangeSupport.firePropertyChange(property.name, oldValue, newValue)
    }

    var money: Long by Delegates.observable(0, observer)
    var moneyPerSecond = 0
    var fastUP = 1 // 1 = x1, 2 = x10, 3 = x25, 4 = xMax
    var butchers:Array<Butcher> = arrayOf()

    fun addButcher(butcher: Butcher) {
        butchers.plus(butcher)
    }

    fun hardReset() {
        money = 0
    }

}