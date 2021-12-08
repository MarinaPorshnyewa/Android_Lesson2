package com.example.myapplication

open class Film(val nameFilm: String,
                val countryFilm: MutableSet<String>,
                val genre: MutableSet<String>,
                val date: Long): Cinema(nameFilm, countryFilm) {
}