package com.example.makemoremeat.models

import com.example.makemoremeat.enumerations.EnumProduction
import com.example.makemoremeat.enumerations.EnumRarity

class Butcher(
    private val rarity: EnumRarity,
    private val production: EnumProduction
) {

    private val level: Int = 0
}