package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {



    private var textView: TextView? = null
    private var textView2: TextView? = null
    private var textView3: TextView? = null
    private var textView4: TextView? = null
    private var textView5: TextView? = null
    private lateinit var button: Button
    private var count: Int = 1
    private lateinit var button2: Button
    private var count2: Int = 1
    private var textView6: TextView? = null
    private var textView7: TextView? = null
    private var textView8: TextView? = null
    private var textView9: TextView? = null
    private var textView10: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.textView)
        textView2 = findViewById<TextView>(R.id.textView2)
        textView3 = findViewById<TextView>(R.id.textView3)
        textView4 = findViewById<TextView>(R.id.textView4)
        textView5 = findViewById<TextView>(R.id.textView5)
        button = findViewById<Button>(R.id.button)
        button2 = findViewById<Button>(R.id.button2)
        textView6 = findViewById<TextView>(R.id.textView6)
        textView7 = findViewById<TextView>(R.id.textView7)
        textView8 = findViewById<TextView>(R.id.textView8)
        textView9 = findViewById<TextView>(R.id.textView9)
        textView10 = findViewById<TextView>(R.id.textView10)

        //Task_1.1
        getFib()
        //Task_1.2
        for(n in 0..20){
            textView2?.append(getFib2(n).toString() + " ")
        }

        //Task_2
        randValue()

        //Task_5
        textView4?.append("Сумма " + ValueClass(4, 6).sumCalculate().toString())

        //Task_6
        button.setOnClickListener{
            textView5?.text = "Количество нажатий: " + count.toString()
            count++
        }

        //Task_7
        button2.setOnClickListener{
            when(count2){
                1 -> textView6?.text = ValueClass(3, 9).toString()
                2 -> textView7?.text = ValueClass(5, 4).toString()
                3 -> textView8?.text = ValueClass(9, 12).toString()
                4 -> textView9?.text = ValueClass(4, 1).toString()

            }

            count2++
        }
        //Task3 + Task4
        val student: Util = Util(Student("Marina", 30, 9, 10))
        textView10?.append("Сумма оценок: " + student.sumMark().toString())
    }

    //Task_1.1
    fun getFib(){
        var a: Int = 0
        var b: Int = 1
        var i: Int = 0

        textView?.append(a.toString() + " " + b.toString() + " ")
        for (n in 1..17){
            i = a + b
            a = b
            b = i
            textView?.append(i.toString() + " ")
        }
    }

    //Task_1.2
    fun getFib2(n: Int): Int{

        if(n == 0){
            return 0
        }
        if(n == 1){
            return 1
        }
        else{
            return getFib2(n - 1) + getFib2(n - 2)
        }
    }

    //Task_2
    fun randValue(){
        val x = Random.nextInt(0, 100)
        val y = Random.nextInt(0, 100)
        val valueClass: ValueClass = ValueClass(x, y)
        textView3?.append("Класс с рандомными числами: " + valueClass.toString())
    }
}