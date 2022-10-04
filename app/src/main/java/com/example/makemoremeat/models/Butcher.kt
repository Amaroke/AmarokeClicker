package com.example.makemoremeat.models

import com.example.makemoremeat.enumerations.ProductionInformation
import com.example.makemoremeat.enumerations.Rarity

class Butcher(
    private val rarity: Rarity,
    private val production: ProductionInformation
) {

    private val level: Int = 0

}