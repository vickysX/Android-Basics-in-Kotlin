package com.example.cities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(private val letterId: String, context: Context) : RecyclerView.Adapter<CityAdapter.CityHolder>() {

    private val cityList: List<String>

    init {
        val cities = context.resources.getStringArray(R.array.cities).toList()
        cityList = cities.filter {it.startsWith(letterId)}.shuffled().sorted()
    }

    class CityHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val cityButton = view.findViewById<com.google.android.material.button.MaterialButton>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return CityHolder(layout)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val city = cityList[position]
        val context = holder.view.context
        holder.cityButton.text = city
        holder.cityButton.setOnClickListener {
            val queryUrl = Uri.parse("${CityListFragment.SEARCH_PREFIX}${city}")
            val wikiIntent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(wikiIntent)
        }
    }

    override fun getItemCount(): Int = cityList.size
}