package com.example.myapplication

open class Series(
    val nameSeries: String,
    val countrySeries: MutableSet<String>,
    val numberOfSeasons: Int,
    val genre: MutableSet<String>
) : Cinema(nameSeries, countrySeries) {
    private var mark: Double
        get() = mark
        set(mark) {
            if (mark < 0 || mark > 10) {
                this.mark = 0.0
            } else {
                this.mark = mark
            }
        }
    private var collectedMoney: Long
        get() = collectedMoney
        set(collectedMoney) {
            if (collectedMoney < 0) {
                this.collectedMoney = 0
            } else {
                this.collectedMoney = collectedMoney
            }
        }
}