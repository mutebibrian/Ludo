package com.intellectsoft.ludo

class Dice (private val numSides:Int){
    //Do a random dice roll and return the results
    fun roll():Int{
        return(1..numSides).random()
    }
}