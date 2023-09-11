package com.example.openlibrarys05.ws

import retrofit2.http.GET
import retrofit2.http.Query

interface LibroService {
    //https://openlibrary.org/search.json?q=android-security
    @GET("/search.json")
    suspend fun buscar(@Query("q") terminoDeBusqueda:String):ResultadoBusquedaLibros

}