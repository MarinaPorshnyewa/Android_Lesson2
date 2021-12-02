package com.example.myapplication

open class People(val name: String, val age: Int) {
}

class Student(nameOfStudent: String, ageOfStudent: Int, val mark1: Int, val mark2: Int): People(nameOfStudent, ageOfStudent){

}