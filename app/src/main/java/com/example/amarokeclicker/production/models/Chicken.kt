package com.example.amarokeclicker.production.models

import com.example.amarokeclicker.R

class Chicken : Production(10, 1, 5, R.drawable.chicken) {

    init {
        numberPossessed = 1
    }

    override fun upgradeProduction() {
        numberPossessed++
        actualProduction++
        actualCost += 10
    }


}