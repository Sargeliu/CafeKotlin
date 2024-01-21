package com.example.cafekotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cafekotlin.databinding.ActivityMakeOrderBinding

class MakeOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMakeOrderBinding
    private lateinit var userName: String
    private lateinit var greetings: String
    private lateinit var drink: String
    private lateinit var additivesLabel: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
        binding = ActivityMakeOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUserName()
        binding.radioGroupDrinks.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                binding.radioButtonTea.id -> onUserChooseTea()
                binding.radioButtonCoffee.id -> onUserChooseCoffee()

            }
        }
        binding.radioButtonTea.isChecked = true

        binding.buttonMakeOrder.setOnClickListener { onUserMadeOrder() }
    }

    private fun onUserMadeOrder() {
        val additives = arrayListOf<String>()
        if (binding.checkBoxSugar.isChecked) {
            additives.add(binding.checkBoxSugar.text.toString())
        }
        if (binding.checkBoxMilk.isChecked) {
            additives.add(binding.checkBoxMilk.text.toString())
        }
        if (binding.radioButtonTea.isChecked && binding.checkBoxLemon.isChecked) {
            additives.add(binding.checkBoxLemon.text.toString())
        }

        var drinkType: String = ""
        if (binding.radioButtonTea.isChecked) {
            drinkType = binding.spinnerTea.selectedItem.toString()
        } else if (binding.radioButtonCoffee.isChecked) {
            drinkType = binding.spinnerCoffee.selectedItem.toString()
        }

        val intent = OrderDetailActivity.newIntent(this,
            userName,
            drink,
            additives.toString(),
            drinkType
            )
        startActivity(intent)
    }


    private fun onUserChooseTea() {
        drink = getString(R.string.tea)
        additivesLabel = getString(R.string.additives, drink)
        binding.textViewAdditives.text = additivesLabel
        binding.checkBoxLemon.visibility = View.VISIBLE
        binding.spinnerTea.visibility = View.VISIBLE
        binding.spinnerCoffee.visibility = View.INVISIBLE
    }

    private fun onUserChooseCoffee() {
        drink = getString(R.string.coffee)
        additivesLabel = getString(R.string.additives, drink)
        binding.textViewAdditives.text = additivesLabel
        binding.checkBoxLemon.visibility = View.INVISIBLE
        binding.spinnerTea.visibility = View.INVISIBLE
        binding.spinnerCoffee.visibility = View.VISIBLE
    }

    private fun setupUserName() {
        userName = intent.getStringExtra(EXTRA_USER_NAME).toString()
        greetings = getString(R.string.greetings, userName)
        binding.textViewGreetings.text = greetings
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