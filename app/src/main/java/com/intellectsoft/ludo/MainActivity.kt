package com.intellectsoft.ludo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    //we are creating a variable for ad view and ad request
    lateinit var adView: AdView
    lateinit var adRequest: AdRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //We are inintiallizing our mobile ads
        MobileAds.initialize(this)
        //initiallizing our adview with its ID
        adView=findViewById(R.id.adview)
        //Initiallizing our ad request
        adRequest =AdRequest.Builder().build()
        //We are Loading our adview withthe adrequest
        adView.loadAd(adRequest)




        val rollButton = findViewById<Button>(R.id.btnroll)
        rollButton.setOnClickListener { rollDice() }
        //do a dice roll when the app starts
        rollDice()

    }

    private fun rollDice() {
//create new dice objects with 6 sides and roll it
    val dice = Dice(6)
        val diceRoll =dice.roll()
        //Find the imageview in the layout
        val diceimage = findViewById<ImageView>(R.id.ivdice)
        //Determine which drawable resource id to use based on the dice roll use when else statement
        val drawableResource = when (diceRoll){
            1 ->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        //update image view with the correct drawable resource id
        diceimage.setImageResource(drawableResource)
        //update the content discription
        diceimage.contentDescription=diceRoll.toString()


    }

}