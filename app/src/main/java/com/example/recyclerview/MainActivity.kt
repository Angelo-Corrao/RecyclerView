package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var titles: Array<String>
    private lateinit var descriptions: Array<String>
    private lateinit var images: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        titles = this.resources.getStringArray(R.array.titles)
        descriptions = this.resources.getStringArray(R.array.descriptions)
        images = listOf<Int>(R.drawable.c_plus_plus, R.drawable.c_sharp, R.drawable.java, R.drawable.kotlin,
            R.drawable.scala, R.drawable.javascript, R.drawable.typescript, R.drawable.python, R.drawable.swift, R.drawable.php)

        val myAdapter = MyAdapter(this, titles, descriptions, images)
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}