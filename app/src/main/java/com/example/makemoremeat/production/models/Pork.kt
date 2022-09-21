package com.example.makemoremeat.production.models

import com.example.makemoremeat.R

class Pork : Production(100, 20, 30, R.drawable.pork) {

    init {
        numberPossessed = 1
    }

    override fun upgradeProduction() {
        numberPossessed++
        actualProduction++
        actualCost += 10
    }


}