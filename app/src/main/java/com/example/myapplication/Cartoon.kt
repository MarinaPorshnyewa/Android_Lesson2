package com.example.myapplication

open class Cartoon(
    val nameCartoon: String,
    val countryCartoon: MutableSet<String>,
    val date: Long
) : Cinema(nameCartoon, countryCartoon) {
    private var collectedMoney: Long
        get() = collectedMoney
        set(collectedMoney) {
            if (collectedMoney < 0) {
                this.collectedMoney = 0
            } else {
                this.collectedMoney = collectedMoney
            }
        }
    private var typeAnimation: String
        get() = typeAnimation
        set(typeAnimatione) {
            this.typeAnimation = typeAnimation
        }
}