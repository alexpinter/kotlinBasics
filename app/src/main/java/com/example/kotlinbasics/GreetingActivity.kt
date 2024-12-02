package com.example.kotlinbasics

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GreetingActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var greetingButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_greeting)

        nameEditText = findViewById(R.id.nameEditText)
        greetingButton = findViewById(R.id.greetingButton)
        resultTextView = findViewById(R.id.resultTextView)


        greetingButton.setOnClickListener(){
            val name = nameEditText.text
            if (name.isNotEmpty()){

                var greetingText = when {
                    name.length <= 3 -> "Hello $name! De rövid neved van"
                    name.length >= 10 -> "Hello $name! De hosszú neved van"
                    else -> "Hello $name!"
                }
                resultTextView.text = greetingText
                //hideKeyboard()
                nameEditText.text.clear()

            }else{
                //hiaüzenet ha üres a name
                Toast.makeText(this, "Kérlek add meg a nevedet!", Toast.LENGTH_SHORT).show()
            }

        }//set on klikk 1

    }
}