package com.example.kmamillas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_a_millas = findViewById<Button>(R.id.btn_a_millas)
        val btn_a_km = findViewById<Button>(R.id.btn_a_km)
        val btnToMetros = findViewById<Button>(R.id.btn_a_metros)
        val btnToPies = findViewById<Button>(R.id.btn_a_pies)

        val edit_km = findViewById<EditText>(R.id.edit_km)
        val edit_millas = findViewById<EditText>(R.id.edit_millas)
        val editPies = findViewById<EditText>(R.id.edit_pies)
        val editMetros = findViewById<EditText>(R.id.edit_metros)

        btn_a_millas.setOnClickListener {
            val skm = edit_km.text.toString()
            if (skm.isNotEmpty() && skm.toFloat() != 0f) {
                val km = skm.toFloat()
                val millas = km / 1.609f
                val smillas = String.format("%.2f", millas)
                edit_millas.setText(smillas)
            } else {
                edit_millas.error = "Por favor asegúrate que has colocado el valor en el lugar correcto"
            }
        }

        btn_a_km.setOnClickListener {
            val smillas = edit_millas.text.toString()
            if (smillas.isNotEmpty() && smillas.toFloat() != 0f) {
                val millas = smillas.toFloat()
                val km = millas * 1.609f
                val skm = String.format("%.2f", km)
                edit_km.setText(skm)
            } else {
                edit_km.error = "Por favor asegúrate que has colocado el valor en el lugar correcto"
            }
        }

        btnToMetros.setOnClickListener {
            val pies = editPies.text.toString().toFloatOrNull()
            if (pies != null) {
                val metros = pies * 0.3048
                editMetros.setText("%.2f".format(metros))
            } else {
                editMetros.error = "Por favor, asegúrate que has colocado el valor en el lugar correcto."
            }
        }

        btnToPies.setOnClickListener {
            val metros = editMetros.text.toString().toFloatOrNull()
            if (metros != null) {
                val pies = metros / 0.3048
                editPies.setText("%.2f".format(pies))
            } else {
                editPies.error = "Por favor, asegúrate que has colocado el valor en el lugar correcto."
            }
        }
    }
}
