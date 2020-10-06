package edu.bo.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val bookDao =
                AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            repository.insert(Book("Alguien","5", "Algo","alguien","desc","asdasd"))
                val lista = repository.getListBooks()
                lista.forEach {
                Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}")
            }
        }
    }
}