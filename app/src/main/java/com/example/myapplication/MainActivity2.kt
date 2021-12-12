package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private var textView10: TextView? = null
    private lateinit var add: Button
    private lateinit var next: Button
    private lateinit var previous: Button
    private lateinit var delete: Button
    private var n: Int = 0
    private var nNext: Int = 1
    private var nPrevious: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView10 = findViewById(R.id.textView10)
        add = findViewById(R.id.button3)
        next = findViewById(R.id.button5)
        previous = findViewById(R.id.button4)
        delete = findViewById(R.id.button6)

        val cinema: ArrayList<Cinema> = arrayListOf(
            Film("House of Gucci", mutableSetOf("Canada", "USA"), mutableSetOf("biography", "drama", "crimes", "thriller"), 2021),
            Film("King Richard", mutableSetOf("USA"), mutableSetOf("drama", "sport"), 2021),
            Series("Emily in Paris", mutableSetOf("USA"), 1, mutableSetOf("comedy-drama", "romantic comedy")),
            Series("Ginny and Georgia", mutableSetOf("USA"), 1, mutableSetOf("comedy-drama")),
            Cartoon("Encanto", mutableSetOf("USA"), 2021),
            Cartoon("TheBossBaby", mutableSetOf("USA"), 2017)
        )

        fun info(n: Int): String{
            val film = WishList.myPreferences[n]
            when(film){
                is Film -> {
                    return film.getTitleFilm()
                }
                is Series -> {
                    return film.getTitleSeries()
                }
                is Cartoon -> {
                    return film.getTitleCartoon()
                }
                else -> return ""
            }
        }


        add.setOnClickListener {
            if (n < cinema.size) {
                val film = cinema[n]
                WishList.myPreferences.add(film)
                n++
            } else {
                textView10?.text = ""
            }
        }

        next.setOnClickListener {
            when {
                WishList.myPreferences.isEmpty() -> {
                    textView10?.text = ""
                }
                textView10?.text == "" -> {
                    textView10?.text = info(0)
                    nNext = 0
                }
                WishList.myPreferences.size == (nNext + 1) -> {
                    textView10?.text = info(nNext)
                }
                else -> {
                    nNext++
                    textView10?.text = info(nNext)
                    nPrevious = (nNext - 1)
                }

            }
        }

        previous.setOnClickListener {
            when{
                WishList.myPreferences.isEmpty() -> {
                    textView10?.text = ""
                }
                textView10?.text == "" || textView10?.text == WishList.myPreferences[0].toString() -> {
                    textView10?.text = info(0)
                    nNext = 0
                }
                nPrevious < 0 -> {
                    textView10?.text = info(0)
                }
                else -> {
                    textView10?.text = info(nPrevious)
                    nNext = nPrevious
                    nPrevious--
                }
            }
        }

        delete.setOnClickListener {

            when{
                WishList.myPreferences.isEmpty() -> {
                    textView10?.text = ""
                }
                else -> {
                    WishList.myPreferences.removeAt(nNext)
                    textView10?.text = ""
                }
            }
        }
    }
}