package com.example.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val peso = findViewById<EditText>(R.id.peso)
        val altura = findViewById<EditText>(R.id.altura)

        peso.doAfterTextChanged { text ->
            //Toast.makeText(this,text.toString(),Toast.LENGTH_SHORT).show()
        }

        altura.doAfterTextChanged { text ->
            //Toast.makeText(this,text.toString(),Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.bt_calc).setOnClickListener{calcIMC(peso.text.toString(),altura.text.toString())

        }


    }

    private fun calcIMC(peso: String, altura:String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()?.div(100)

        if (peso != null && altura != null) {
            val imc = peso/(altura*altura)
            textView.text = "%.2f".format(imc)
        }
    }
    override fun onStart() {
        super.onStart()
        Log.w("Lifecycle","OnStart")
    }

    override fun onPause() {
        super.onPause()
        Log.w("Lifecycle","onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.w("Lifecycle","OnStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("Lifecycle","OnDestroy")

    }

    override fun onRestart() {
        Log.w("Lifecycle","OnRestart")
        super.onRestart()
    }
}