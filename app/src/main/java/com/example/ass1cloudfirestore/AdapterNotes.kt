package com.example.ass1cloudfirestore

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.notes.view.*

class AdapterNotes( var activity: Activity, var data:ArrayList<Moodle_Notes>): RecyclerView.Adapter<AdapterNotes.MyNotes>(){
    class MyNotes (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.nameNote
        val description =itemView.descriptionNote
        val characterCount =itemView.characterCountNote

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNotes {

        val root = LayoutInflater.from(activity).inflate(R.layout.notes,parent , false)

        return MyNotes(root)
    }

    override fun onBindViewHolder(holder: MyNotes, position: Int) {

        holder.name.text=data[position].name
        holder.description.text=data[position].description
        holder.characterCount.text=data[position].character_count.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }


}