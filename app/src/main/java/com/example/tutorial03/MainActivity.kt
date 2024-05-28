package com.example.tutorial03

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import models.Calculator

class MainActivity : AppCompatActivity() {

    private lateinit var editNumber1:EditText
    private lateinit var editNumber2:EditText
    private lateinit var rs_view:TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNumber1=findViewById(R.id.editNumber1)
        editNumber2=findViewById(R.id.editNumber2)


        val buttons= listOf(R.id.btnPlus,R.id.btnMinus,R.id.btnMultiply,R.id.btnDivide)
        buttons.forEach { id -> findViewById<View>(id).setOnClickListener{buttonClick(it)} }

    }

    fun buttonClick(v: View){
        var ans = 0.0
        val calculator = Calculator(
            editNumber1.text.toString().toDouble(),
            editNumber2.text.toString().toDouble())
        when(v.id){
            R.id.btnPlus -> ans = calculator.add()
            R.id.btnMinus -> ans = calculator.subtract()
            R.id.btnMultiply -> ans = calculator.multiply()
            R.id.btnDivide -> ans = calculator.divide()
        }

        val intents = Intent(this,DisplayActivity::class.java)
        intents.putExtra("result",ans)
        startActivity(intents)
        finish()
    }
}