package com.example.openlibrarys05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.openlibrarys05.ui.theme.OpenLibraryS05Theme
import com.example.openlibrarys05.ws.Fabrica
import com.example.openlibrarys05.ws.Libro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppLibrosUI()
        }
    }
}
@Composable
fun AppLibrosUI(){

    val (libros, setLibros)= remember {
        mutableStateOf(emptyList<Libro>())
    }

    LaunchedEffect(Unit){
        withContext(Dispatchers.IO){
            val service = Fabrica.getLibroService()
            setLibros (service.buscar("android").docs)
        }
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        items(libros){libro ->
            Text(libro.titulo)
        }
    }
}