package com.example.login_signup_firebase

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.login_signup_firebase.databinding.NotesItemBinding

class NoteAdapter(private val notes: List<NoteItem>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class NoteViewHolder(private var binding: NotesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteItem) {
binding.titleTextview.text=note.title
        binding.descTextView.text=note.description}

    }
}