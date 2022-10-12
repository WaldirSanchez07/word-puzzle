package com.example.buscatunombre

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener


class MainActivity : AppCompatActivity() {

    val EXTRA_NOMBRE = "NombreActivity2"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNombre: EditText = findViewById(R.id.txtName)
        val btnNext: Button = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            if (etNombre.text.toString().equals("")) {
                Toast.makeText(baseContext, "Escribe un nombre!", Toast.LENGTH_LONG).show()
            } else {
                var cad10: String = ""
                if (etNombre.text.toString().length > 10) {
                    cad10 = etNombre.text.toString().slice(0..9)
                } else {
                    cad10 = etNombre.text.toString()
                }
                goActivityBuscarNombre(cad10)
            }
        }
    }

    fun goActivityBuscarNombre(nombre: String) {

        val intent = Intent(this, BuscarNombre::class.java).apply {
            putExtra(EXTRA_NOMBRE, nombre)
        }

        startActivity(intent)
    }

}