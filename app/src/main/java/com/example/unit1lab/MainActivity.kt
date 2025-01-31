package com.example.unit1lab

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)
        button.setOnClickListener {
            counter++
            textView.text = counter.toString()
            if (counter >= 100){
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener{
                    button.text = "Add 2"

                    button.setOnClickListener{
                        counter += 2
                        textView.text = counter.toString()
                    }

                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}