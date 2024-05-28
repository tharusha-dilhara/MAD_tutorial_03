package com.example.tutorial03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        var textAnswer=findViewById<TextView>(R.id.answer_rs)
        textAnswer.setText(intent.getDoubleExtra("result",0.0).toString())

        var btnback=findViewById<Button>(R.id.btn_back)
        btnback.setOnClickListener {
            var intent_2= Intent(this,MainActivity::class.java)
            startActivity(intent_2)
            finish()
        }

    }
}