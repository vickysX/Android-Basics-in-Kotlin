package com.example.kitties.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kitties.LilithActivity
import com.example.kitties.NikeKorokiActivity
import com.example.kitties.R
import com.example.kitties.model.Cat

class CatAdapter(private val context: Context, private val data: List<Cat>) : RecyclerView.Adapter<CatAdapter.CatHolder>() {

    class CatHolder(private val view: View?) : RecyclerView.ViewHolder(view!!) {
        val picture = view?.findViewById<ImageView?>(R.id.cat_picture)
        val name = view?.findViewById<TextView>(R.id.cat_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent, false)
        return CatHolder(layout)
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        val cat = data[position]
        holder.picture?.setImageResource(cat.picture)
        holder.name?.text = context.resources.getString(cat.name)
        holder.itemView.setOnClickListener {
            val intent: Intent = when (position) {
                0 -> Intent(context, NikeKorokiActivity::class.java)
                else -> Intent(context, LilithActivity::class.java)
            }
            startActivity(context, intent, null)
        }
    }

    override fun getItemCount(): Int = data.size
}