package edu.bo.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            //repository.insert(Book("Alguien","5", "Algo","alguien","desc","https://i.imgur.com/tGbaZCY.jpg"))
            val lista = repository.getListBooks()

            bookRecyclerView.adapter = bookListAdapter(lista as ArrayList<Book>, applicationContext)

            var linearLayoutManager = LinearLayoutManager(applicationContext)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            bookRecyclerView.layoutManager = linearLayoutManager
        }

        val addFloatingButon: View = findViewById(R.id.floatingAddButon)
        addFloatingButon.setOnClickListener {
            startActivity(Intent(this, addBookActivity::class.java))
        }


    }
}
