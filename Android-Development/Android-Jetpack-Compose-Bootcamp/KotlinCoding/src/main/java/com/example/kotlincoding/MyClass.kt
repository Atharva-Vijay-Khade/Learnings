package com.example.kotlincoding


fun main() {

    // lambda function
    val add: (a:Int, b:Int) -> Int = { a,b -> a+b }
    val showName: (String) -> Unit = {
        println(it)
    }
    val doNothing: () -> Unit = { }


    showNameBMI("atharva", 79, 179) {
        wt, ht -> ((wt*1.0)/ht)*100
    }

    println("${add(1,2)}")
    showName("Atharva")
    doNothing()

}

fun showNameBMI(name: String, wt: Int, ht: Int, calculateBMI: (wt: Int, ht: Int) -> Double) {
    println("Hi $name your BMI is ${calculateBMI(wt, ht)}")
}