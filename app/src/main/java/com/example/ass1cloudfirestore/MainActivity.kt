package com.example.ass1cloudfirestore

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    private lateinit var notesArrayList: ArrayList<Moodle_Notes>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        all_notes.layoutManager = LinearLayoutManager(this)
        notesArrayList = arrayListOf<Moodle_Notes>()

        but_Add.setOnClickListener {

            val i = Intent(this, AddNotesActivity::class.java)
            startActivity(i)

        }



    }


    fun getAllNotes(){

        db.collection("notes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                   val note= document.toObject(Moodle_Notes::class.java)
                    notesArrayList.add(note)
                    Log.d("Read Data", "${document.id} => ${document.data}")


                }

                 all_notes.adapter = AdapterNotes(this,notesArrayList)

            }
            .addOnFailureListener { exception ->
                Log.w("Read Data", "Error getting documents.", exception)
            }







    }


    override fun onResume() {
        super.onResume()
        notesArrayList.clear()
        getAllNotes()
    }












}










