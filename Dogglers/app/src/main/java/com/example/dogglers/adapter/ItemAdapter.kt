package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.Datasource
import com.example.dogglers.layout.Layouts
import com.example.dogglers.model.Dog

class ItemAdapter(private val context: Context, private val layout: Int) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private val data: List<Dog> = Datasource().loadDogs()

    class ItemViewHolder(private val view: View?) : RecyclerView.ViewHolder(view!!) {
        val imageView = view?.findViewById<ImageView>(R.id.dog_picture)
        val nameView = view?.findViewById<TextView>(R.id.dog_name)
        val ageView = view?.findViewById<TextView>(R.id.dog_age)
        val hobbiesView = view?.findViewById<TextView>(R.id.dog_hobbies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val view = when (layout) {
            Layouts.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.horizontal_vertical_list_item, parent, false)
        }
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val dog = data[position]
        val resources = context?.resources
        holder.imageView?.setImageResource(dog.picture)
        holder.nameView?.text = dog.name
        holder.ageView?.text = resources.getString(R.string.dog_age, dog.age)
        holder.hobbiesView?.text = resources.getString(R.string.dog_hobbies, dog.hobbies)
    }

    override fun getItemCount(): Int = data.size

}