package com.example.makemoremeat

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Jeu : PropertyChangeAware() {

    private val observer = {
            property: KProperty<*>,
            oldValue: Any,
            newValue: Any -> propertyChangeSupport.firePropertyChange(property.name, oldValue, newValue)
    }

    var money: Long by Delegates.observable(0, observer)
    var moneyPerSecond = 0
    var fastUP = 1 // 1 = x1, 2 = x10, 3 = x25, 4 = xMax

    fun hardReset() {
        money = 0
    }

}