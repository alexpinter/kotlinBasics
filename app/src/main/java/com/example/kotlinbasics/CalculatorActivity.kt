package com.example.kotlinbasics

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {

    private lateinit var elsoEditText: EditText
    private lateinit var masodikEditText: EditText
    private lateinit var osszeadasButton: Button
    private lateinit var torlesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //    insets
        //}


        elsoEditText = findViewById(R.id.elsoEditText)
        masodikEditText = findViewById(R.id.masodikEditText)
        osszeadasButton = findViewById(R.id.osszeadasButton)
        torlesButton = findViewById(R.id.torlesButton)


        

    }
}