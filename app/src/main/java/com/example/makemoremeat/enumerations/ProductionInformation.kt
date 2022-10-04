package com.example.makemoremeat.enumerations

enum class ProductionInformation(
    val initialNumber: Double,
    val initialCost: Double,
    val initialProduction: Double,
    val initialProductionTime: Double
) {

    Chicken(1.0, 1.0, 1.0, 2.0),
    Beef(0.0, 5.0, 5.0, 2.0),
    Mutton(0.0, 15.0, 15.0, 2.0),
    Pork(0.0, 20.0, 20.0, 2.0),
    Rabbit(0.0, 25.0, 25.0, 2.0),
    Horse(0.0, 30.0, 30.0, 2.0),
    Caribou(0.0, 35.0, 35.0, 2.0),
    Fish(0.0, 40.0, 40.0, 2.0),
    Dog(0.0, 45.0, 45.0, 2.0),
    Elephant(0.0, 50.0, 50.0, 2.0),
    Bugs(0.0, 55.0, 55.0, 2.0),
    Vegan(0.0, 60.0, 60.0, 2.0),
    Cultured(0.0, 65.0, 65.0, 2.0)
}