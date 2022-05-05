package com.example.cities


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.findNavController
import androidx.navigation.NavDirections

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val letters = ('A').rangeTo('Z').toList()

    class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<com.google.android.material.button.MaterialButton>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return LetterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = letters[position]

        holder.button.text = item.toString()
        holder.button.setOnClickListener {
            val action: NavDirections = LetterListFragmentDirections.actionLetterListFragmentToCityListFragment(
                holder.button.text.toString()
            )
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = letters.size
}