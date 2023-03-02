package com.example.ass1cloudfirestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_add_notes.*

class AddNotesActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)


        but_addNote.setOnClickListener {
            if (note_name.text.toString().isNotEmpty() && note_description.text.toString().isNotEmpty()&& character_count.text.toString().isNotEmpty()){
                addNotes(note_name.text.toString(),note_description.text.toString(),character_count.text.toString().toInt())

            }else{
                Toast.makeText(this,"The appropriate data must be entered in the fields", Toast.LENGTH_SHORT).show()
            }
        }


    }



    private fun addNotes(name: String,description: String? , characterCount: Int?) {

        val notes = hashMapOf("name" to name,
            "description" to description,
            "character_count" to characterCount)

        db.collection("notes")
            .add(notes)
            .addOnSuccessListener { documentReference ->
                Log.d("Add Data", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Add Data", "Error adding document", e)
            }
    }


}