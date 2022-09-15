package com.example.amarokeclicker

class Chicken : Production(10, 1, 5) {

    init {
        numberPossessed = 1
    }

    fun upgradeProduction() {
        numberPossessed++
        actualProduction++
        actualCost += 10
    }


}