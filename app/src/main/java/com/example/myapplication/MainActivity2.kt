package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private var textView10: TextView? = null
    private var textView11: TextView? = null
    private lateinit var add: Button
    private var n: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView10 = findViewById(R.id.textView10)
        textView11 = findViewById(R.id.textView11)
        add = findViewById(R.id.button3)

        fun info2(){

            for(i in 0..AllCinema<Cinema>().allCinema.size-1){
                val film = AllCinema<Cinema>().allCinema[i]
                when(film){
                    is Film -> {
                        textView11?.append(film.getTitleFilm()+ "\n")
                    }
                    is Series -> {
                        textView11?.append(film.getTitleSeries() + "\n")
                    }
                    is Cartoon -> {
                        textView11?.append(film.getTitleCartoon() + "\n")
                    }
                }
            }
        }

        info2()

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
            if (n < AllCinema<Cinema>().allCinema.size) {
                val film = AllCinema<Cinema>().allCinema[n]
                WishList.myPreferences.add(film)
                textView10?.append(info(n) + "\n")
                n++
            } else {
                textView10?.text = ""
                n = 0
            }
        }
    }
}