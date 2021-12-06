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

        val film: ArrayList<Cinema> = arrayListOf(
            HouseOfGucci("HouseOfGucci"),
            KingRichard("KingRichard"),
            Eternals("Eternals"),
            Encanto("Encanto"),
            TheBossBaby("TheBossBaby"),
            EmilyInParis("EmilyInParis"),
            SexEducation("SexEducation"),
            GinnyAndGeorgia("GinnyAndGeorgia")
        )

        add.setOnClickListener(){
            if(n < film.size) {
                WishList.myPreferences.add(film[n])
                n++
            }else{
                textView10?.text = ""
            }
        }

        next.setOnClickListener(){
            if(textView10?.text == "")
            {
                textView10?.text = WishList.myPreferences[0].toString()
                nNext = 0
            }else if(WishList.myPreferences.isEmpty()){
                textView10?.text = ""
            }else if(WishList.myPreferences.size == (nNext+1)){
                textView10?.text = WishList.myPreferences[nNext].toString()
            }else{
                nNext++
                textView10?.text = WishList.myPreferences[nNext].toString()
                nPrevious = (nNext-1)
            }

        }

        previous.setOnClickListener(){
            if(textView10?.text == "" || textView10?.text == WishList.myPreferences[0].toString())
            {
                textView10?.text = WishList.myPreferences[0].toString()
                nNext = 0

            }else if(WishList.myPreferences.isEmpty()){
                textView10?.text = ""
            }else{
                textView10?.text = WishList.myPreferences[nPrevious].toString()
                nNext = nPrevious
                nPrevious--

            }
        }

        delete.setOnClickListener(){
            WishList.myPreferences.removeAt(nNext)
            textView10?.text = ""

        }
    }
}