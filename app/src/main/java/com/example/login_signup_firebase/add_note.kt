package com.example.login_signup_firebase

import android.os.Bundle
import android.widget.Toast
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.login_signup_firebase.databinding.ActivityAddNoteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class add_note : AppCompatActivity() {

    private val binding: ActivityAddNoteBinding by lazy {
        ActivityAddNoteBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()

        binding.saveNoteBtn.setOnClickListener {
            val title = binding.editTitle.text.toString().trim()
            val description = binding.Description.text.toString().trim()

            if (title.isBlank() || description.isBlank()) {
                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val currentUser = auth.currentUser
            currentUser?.let { user ->
                val noteKey = database.child("users").child(user.uid).child("notes").push().key
                val noteitem = NoteItem(title, description)

                if (noteKey != null) {
                    database.child("users").child(user.uid).child("notes").child(noteKey)
                        .setValue(noteitem)
                        .addOnSuccessListener {
                            Log.d("Firebase", "Note saved successfully: $noteitem")
                            Toast.makeText(this, "Note Saved Successfully", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Log.e("Firebase", "Error saving note", e)
                            Toast.makeText(this, "Note Failed to save", Toast.LENGTH_SHORT).show()
                        }
                }
            }
        }
    }
}
