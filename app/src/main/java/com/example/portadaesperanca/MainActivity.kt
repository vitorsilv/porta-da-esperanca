package com.example.portadaesperanca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validarAbrir(v: View){
        val valor = et_porta.text.toString().toInt()
        if(valor <= 0 || valor > 10){
            Toast.makeText(baseContext, R.string.um_dez_erro, Toast.LENGTH_LONG).show()
        }else{
            val resultadoPorta = Intent(this, ResultadoPorta::class.java)
            resultadoPorta.putExtra("id", valor)
            startActivity(resultadoPorta)
        }
    }
}