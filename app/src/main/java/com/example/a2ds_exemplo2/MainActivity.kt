package com.example.a2ds_exemplo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a2ds_exemplo2.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{CalculateTip()}
    }

    //Evento
    fun  CalculateTip(){
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId){

            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

        }

    }


// Opcao1
// val costOfService = binding.costOfService
// costOfService.hint = "Vixe , mudou o texto"

//Opção 2
// binding.costOfService.hint = "Vixe, muda também o texto"

