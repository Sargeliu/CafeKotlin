package com.example.cafekotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OrderDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail2)
    }


    companion object {
        const val EXTRA_USER_NAME = "userName"
        const val  EXTRA_USER_DRINK = "drink"
        const val  EXTRA_USER_DRINKTYPE = "drinkType"
        const val  EXTRA_USER_ADDITIVES = "additives"

        fun newIntent(context: Context, userName: String, drink: String, additives: String, drinkType: String): Intent {
            val intent = Intent(context, OrderDetailActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, userName)
            intent.putExtra(EXTRA_USER_DRINK, drink)
            intent.putExtra(EXTRA_USER_DRINKTYPE, drinkType)
            intent.putExtra(EXTRA_USER_ADDITIVES, additives)
            return intent
        }
    }
}