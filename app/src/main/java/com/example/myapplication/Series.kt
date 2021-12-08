package com.example.myapplication

open class Series(val nameSeries: String,
                  val countrySeries: MutableSet<String>,
                  val numberOfSeasons: Int,
                  val genre: MutableSet<String>): Cinema(nameSeries, countrySeries) {
}