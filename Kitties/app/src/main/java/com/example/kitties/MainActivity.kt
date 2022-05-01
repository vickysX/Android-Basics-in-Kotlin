package com.example.kitties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitties.adapter.CatAdapter
import com.example.kitties.data.CatSource
import com.example.kitties.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView

        chooseLayout()

    }

    // choose the layout manager based on the value of isLinearLayoutManager
    // initializes the adapter
    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        recyclerView.adapter = CatAdapter(this, CatSource().loadCats())
        recyclerView.setHasFixedSize(true)
    }

    // set the menu button icon
    // if the current layout is linear it sets the grid icon and vice versa
    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null) return

        menuItem.icon = when (isLinearLayoutManager) {
            true -> ContextCompat.getDrawable(this, R.drawable.ic_grid_view)
            else -> ContextCompat.getDrawable(this, R.drawable.ic_linear_view)
        }
    }

    // create the menu, inflate the menu layout and set the icon (calling setIcon)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
        return true
    }

    // give functionality to the menu button
    // invert layout and menu icon
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}