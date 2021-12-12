package com.example.myapplication

open class Cartoon(
    val nameCartoon: String,
    val countryCartoon: MutableSet<String>,
    val date: Long
) : Cinema(nameCartoon, countryCartoon) {

}