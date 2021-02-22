package com.example.aplikasihitungvolume

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener{
            var intent = Intent(this@MainActivity, BalokActivity::class.java)
            startActivity(intent)
        }

        val button1: Button = findViewById(R.id.button2)
        button1.setOnClickListener{
            var intent = Intent(this@MainActivity, TabungActivity::class.java)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.button3)
        button2.setOnClickListener{
            var intent = Intent(this@MainActivity, KubusActivity::class.java)
            startActivity(intent)
        }

    }
}