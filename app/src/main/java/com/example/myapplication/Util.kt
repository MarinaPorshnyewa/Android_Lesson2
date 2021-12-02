package com.example.myapplication

class Util(val student: Student) {
    fun sumMark(): Int{
        return student.mark1 + student.mark2
    }
}