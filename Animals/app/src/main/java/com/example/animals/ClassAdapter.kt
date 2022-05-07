package com.example.animals

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class ClassAdapter(context: Context) : RecyclerView.Adapter<ClassAdapter.ClassHolder>() {

    private val classList = context.resources.getStringArray(R.array.animal_classes).toList()

    class ClassHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val classButton = view.findViewById<com.google.android.material.button.MaterialButton>(R.id.class_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.class_item, parent, false)
        return ClassHolder(layout)
    }

    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        val item = classList[position]
        holder.classButton.text = item.toString()
        holder.classButton.setOnClickListener {
            val action: NavDirections = AnimalClassesFragmentDirections.actionAnimalClassesFragmentToAnimalSpeciesFragment(holder.classButton.text.toString())
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = classList.size


}