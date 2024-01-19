package com.example.cafekotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.cafekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSignIn.setOnClickListener {
            val userName = binding.editTextName.text.toString().trim()
            val userPassword = binding.editTextPassword.text.toString().trim()

            if (userName.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.error_fields_empty),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                launchNextScreen(userName)
            }
        }
    }

    private fun launchNextScreen(userName: String) {
        val intent = MakeOrderActivity.newIntent(this, userName)
        startActivity(intent)
    }
}