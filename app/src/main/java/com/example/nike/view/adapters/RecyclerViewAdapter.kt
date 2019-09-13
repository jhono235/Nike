package com.example.nike.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

import com.example.nike.R
import com.example.nike.model.results.Definition
import com.example.nike.model.results.DefinitionList
import com.example.nike.view.adapters.RecyclerViewAdapter.ViewHolder
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter(private val definition: List<Definition>?)
    : Adapter<ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount(): Int {
        return definition?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(definition?.get(position), position)


    }





    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(definition: Definition?, position: Int){


            itemView.tvWord.text = definition?.mWord
            itemView.tvDefinition.text = definition?.mDefinition
            itemView.tvUpvotes.text = definition?.mThumbsUp.toString()
            itemView.tvDownvotes.text = definition?.mThumbsDown.toString()

            Log.d("TAG", itemView.tvWord.text.toString())



        }

    }


}

