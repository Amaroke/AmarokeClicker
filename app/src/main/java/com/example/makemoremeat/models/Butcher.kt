package com.example.makemoremeat.models

import com.example.makemoremeat.enumerations.ProductionInformation
import com.example.makemoremeat.enumerations.Rarity
// TODO
// Chicken Butcher : Wings/Nuggets/Tenders Master
// Vegans Butcher : Cannibal Lecter
// TODO
// Gacha 10 levels (3* empty/bronze/silver/gold)
class Butcher(
    private val rarity: Rarity,
    private val production: ProductionInformation
) {

    private val level: Int = 0

}