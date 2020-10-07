package edu.bo.examen

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_book.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class addBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        addButton.setOnClickListener{view ->
            if(validate(listOf<EditText>(titleEditText, pagesEditText, editorialEditText, authorEditText, descriptionEditText, UrlImageEditText))) {
                GlobalScope.launch {
                    val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                    val repository = BookRepository(bookDao)
                    repository.insert(
                        Book(
                            titleEditText.text.toString(),
                            pagesEditText.text.toString(),
                            editorialEditText.text.toString(),
                            authorEditText.text.toString(),
                            descriptionEditText.text.toString(),
                            UrlImageEditText.text.toString()
                        )
                    )
                }
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        cancelButton.setOnClickListener{
            val myIntent = Intent(applicationContext, MainActivity::class.java)
            startActivityForResult(myIntent, 0)
        }
    }

    fun validate(fields: List<EditText>): Boolean {
        for (i in fields.indices) {
            val currentField = fields[i]
            if (currentField.text.isEmpty()) {
                return false
            }
        }
        return true
    }
}