package com.example.portadaesperanca.http

import com.example.portadaesperanca.modelos.Porta
import retrofit2.Call
import retrofit2.http.*

interface PortaApi {
    @GET("/portas/{id}")
    fun escolherPorta(@Path("id") id: Int): Call<Porta>

}