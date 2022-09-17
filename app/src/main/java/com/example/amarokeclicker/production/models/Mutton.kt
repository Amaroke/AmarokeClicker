package com.example.amarokeclicker.production.models

import com.example.amarokeclicker.R

class Mutton : Production(50, 10, 20, R.drawable.mutton) {

    init {
        numberPossessed = 1
    }

    override fun upgradeProduction() {
        numberPossessed++
        actualProduction++
        actualCost += 10
    }


}