package edu.bo.examen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_book.view.*

class bookListAdapter( var list: ArrayList<Book>, applicationContext: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class BookListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.row_book, parent, false)
        return BookListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var book = list[position]
        holder.itemView.titleTextView.text = book.title
        holder.itemView.AuthorTextView.text = book.author
        holder.itemView.DescriptionTextView.text = book.description
    }
}


