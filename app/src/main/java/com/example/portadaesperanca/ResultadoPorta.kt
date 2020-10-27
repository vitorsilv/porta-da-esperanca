package com.example.portadaesperanca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.portadaesperanca.http.PortaApi
import com.example.portadaesperanca.modelos.Porta
import kotlinx.android.synthetic.main.activity_resultado_porta.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultadoPorta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_porta)
        val id = intent.extras?.getInt("id")
        resultadoPorta(id!!)
    }

    fun resultadoPorta(id: Int){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://5f979ada42706e00169575dc.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val requests = retrofit.create(PortaApi::class.java)

        val resposta = requests.escolherPorta(id)

        resposta.enqueue(object: Callback<Porta>{
            override fun onFailure(call: Call<Porta>, t: Throwable) {
                Toast.makeText(baseContext, R.string.erro_req, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Porta>, response: Response<Porta>) {
                val reqBody = response.body()

                tv_resposta.text = reqBody!!.item
            }

        })
    }
}