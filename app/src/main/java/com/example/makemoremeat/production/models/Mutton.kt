package com.example.makemoremeat.production.models

import com.example.makemoremeat.R

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