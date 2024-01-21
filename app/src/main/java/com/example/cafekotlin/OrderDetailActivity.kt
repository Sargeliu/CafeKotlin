package com.example.cafekotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cafekotlin.databinding.ActivityOrderDetailBinding

class OrderDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail2)
        binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        with(binding) {
            textViewName.text = intent.getStringExtra(EXTRA_USER_NAME)
            textViewDrink.text = intent.getStringExtra(EXTRA_USER_DRINK)
            textViewDrinkType.text = intent.getStringExtra(EXTRA_USER_DRINK_TYPE)
            textViewAdditives.text = intent.getStringExtra(EXTRA_USER_ADDITIVES)
        }
    }


    companion object {
        const val EXTRA_USER_NAME = "userName"
        const val  EXTRA_USER_DRINK = "drink"
        const val  EXTRA_USER_DRINK_TYPE = "drinkType"
        const val  EXTRA_USER_ADDITIVES = "additives"

        fun newIntent(context: Context,
                      userName: String,
                      drink: String,
                      additives: String,
                      drinkType: String): Intent {
            val intent = Intent(context, OrderDetailActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, userName)
            intent.putExtra(EXTRA_USER_DRINK, drink)
            intent.putExtra(EXTRA_USER_DRINK_TYPE, drinkType)
            intent.putExtra(EXTRA_USER_ADDITIVES, additives)
            return intent
        }
    }
}