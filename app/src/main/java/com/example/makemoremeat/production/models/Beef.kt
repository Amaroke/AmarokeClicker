package com.example.makemoremeat.production.models

import com.example.makemoremeat.R

class Beef : Production(20, 4, 10, R.drawable.beef) {

    init {
        numberPossessed = 0
    }

    override fun upgradeProduction() {
        numberPossessed++
        actualProduction++
        actualCost += 10
    }


}