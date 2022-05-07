package com.example.animals

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animals.data.AnimalSource
import com.example.animals.model.Animal

class SpeciesAdapter(private val classId: String, context: Context) : RecyclerView.Adapter<SpeciesAdapter.SpeciesHolder>() {

    private var animalList: List<Animal>

    init {
        val animals = AnimalSource().loadAnimals()
        animalList = animals.filter { it.animalClass == classId }
    }

    class SpeciesHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val animalPicture = view?.findViewById<ImageView?>(R.id.animal_picture)
        val animalName = view?.findViewById<TextView?>(R.id.species_name)
        val animalClass = view?.findViewById<TextView?>(R.id.species_class)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.species_item, parent, false)
        return SpeciesHolder(layout)
    }

    override fun onBindViewHolder(holder: SpeciesHolder, position: Int) {
        val animal = animalList[position]
        val context = holder.view.context
        holder.animalPicture.setImageResource(animal.picture)
        holder.animalName.text = context.getString(animal.speciesName)
        holder.animalClass.text = animal.animalClass
        holder.view.setOnClickListener {
            val queryUrl = Uri.parse("${AnimalSpeciesFragment.SEARCH_PREFIX}${holder.animalName.text}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = animalList.size
}