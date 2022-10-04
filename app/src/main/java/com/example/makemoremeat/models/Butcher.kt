package com.example.makemoremeat.models

import android.content.Context
import com.example.makemoremeat.enumerations.ProductionNames
import com.example.makemoremeat.enumerations.Rarity

class Butcher(
    private val rarity: Rarity,
    private val production: ProductionNames
) {

    private val level: Int = 0

}