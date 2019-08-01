package com.tamimi.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // create a food list that contains default choices
        var foodList = mutableListOf("Chinese", "Steak", "Burger", "MacDonal's")

        // add an event listener to the add food button:
        addFoodBtn.setOnClickListener {
            // in the listener check if the food entry is correct and add to the list of food choices
            val foodAdded = addFoodTxt.text.toString()

            if (foodAdded.isNotEmpty()) {
                foodList.add(foodAdded)
                addFoodTxt.text.clear()
//                addFoodTxt.hint = "Enter food"
            } else {
                Toast.makeText(this, "please enter food!", Toast.LENGTH_SHORT).show()
            }
        }

        // add an event listener to the decide button:
        decideBtn.setOnClickListener {
            // pick a random food from the list if the list is not empty
            if (foodList.isNotEmpty() && foodList.size != 1) {
                selctedFoodTxt.text = foodList.random()
            } else {
                Toast.makeText(this, "please fill in more choices", Toast.LENGTH_SHORT).show()
            }
        }

        // delete all the food in the list
        deleteListBtn.setOnClickListener {
            foodList.clear()
            selctedFoodTxt.text = ""
        }
    }
}
