package com.example.makemoremeat.tools

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

@Suppress("LeakingThis")
open class PropertyChangeAware {

    protected val propertyChangeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(listener)
    }
}