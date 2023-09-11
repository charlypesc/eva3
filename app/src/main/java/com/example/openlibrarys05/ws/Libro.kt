package com.example.openlibrarys05.ws

import com.squareup.moshi.Json
import java.util.jar.Attributes.Name

data class ResultadoBusquedaLibros(
    val numFound:Int,
    val docs:List<Libro>,
    val q: String
)


data class Libro (
    @Json(name="title")
    val titulo:String,
    @Json(name="author_name")
    val autores:List<String> = emptyList(),
    @Json(name="cover_i")
    val imagenId: Long?=null
){
    val imagenUrl:String
        get(){
            if(imagenId!=null){
                return "https://covers.openlibrabry.org/b/d/id/${imagenId}-M.jpg"
            }else{
                return "https://upload.wikimedia.org/wikipedia/commons/d/d1/Image_not_available.png"
            }

        }
}