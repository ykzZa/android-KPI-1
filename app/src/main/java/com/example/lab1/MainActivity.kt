package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner : Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.typesArray,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val btn : Button = findViewById(R.id.button)
        btn.setOnClickListener { buttonClick() }
    }

    private fun buttonClick() {
        val textOut : TextView = findViewById(R.id.textView2)
        val spinner : Spinner = findViewById(R.id.spinner)

        val radioBtnApple : RadioButton = findViewById(R.id.radBtnApple)
        val radioBtnOppo : RadioButton = findViewById(R.id.radBtnOppo)
        val radioBtnSamsung : RadioButton = findViewById(R.id.radBtnSamsung)

        if( !radioBtnApple.isChecked and !radioBtnOppo.isChecked and !radioBtnSamsung.isChecked) {
            textOut.text = "Choose firm"
        }

        when {
            radioBtnApple.isChecked -> textOut.text = "You chose Apple ${spinner.selectedItem.toString().lowercase()} phone"
            radioBtnOppo.isChecked -> textOut.text = "You chose Oppo ${spinner.selectedItem.toString().lowercase()} phone"
            radioBtnSamsung.isChecked -> textOut.text = "You chose Samsung ${spinner.selectedItem.toString().lowercase()} phone"
        }
    }
}