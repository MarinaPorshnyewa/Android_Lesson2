package com.example.myapplication

class AllCinema<T: Cinema>() {
    val allCinema: ArrayList<Cinema> = arrayListOf(
        Film("House of Gucci", mutableSetOf("Canada", "USA"), mutableSetOf("biography", "drama", "crimes", "thriller"), 2021),
        Film("King Richard", mutableSetOf("USA"), mutableSetOf("drama", "sport"), 2021),
        Series("Emily in Paris", mutableSetOf("USA"), 1, mutableSetOf("comedy-drama", "romantic comedy")),
        Series("Ginny and Georgia", mutableSetOf("USA"), 1, mutableSetOf("comedy-drama")),
        Cartoon("Encanto", mutableSetOf("USA"), 2021),
        Cartoon("TheBossBaby", mutableSetOf("USA"), 2017)
    )

}