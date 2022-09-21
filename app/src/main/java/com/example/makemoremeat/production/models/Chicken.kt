package com.example.makemoremeat.production.models

import com.example.makemoremeat.R

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