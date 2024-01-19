package com.example.cafekotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cafekotlin.databinding.ActivityMainBinding
import com.example.cafekotlin.databinding.ActivityMakeOrderBinding

class MakeOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMakeOrderBinding
    private lateinit var userName: String
    private lateinit var greetings: String
    private lateinit var drink: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
        binding = ActivityMakeOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent: Intent = intent
        val userName: String? = intent.getStringExtra("userName")
        binding.textViewGreetings.text = userName


    }
    companion object {
        const val EXTRA_USER_NAME = "userName"
        fun newIntent(context: Context, userName: String): Intent {
            val intent = Intent(context, MakeOrderActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, userName)
            return intent
        }
    }

}