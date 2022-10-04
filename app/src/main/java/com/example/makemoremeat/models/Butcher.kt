package com.example.makemoremeat.models

import com.example.makemoremeat.enumerations.Production
import com.example.makemoremeat.enumerations.Rarity

class Butcher(
    private val rarity: Rarity,
    private val production: Production
) {

    private val level: Int = 0
}