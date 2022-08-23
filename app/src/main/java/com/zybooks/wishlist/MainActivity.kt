package com.zybooks.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var wishlistItems = mutableListOf<Wishlist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wishlistRecyclerV = findViewById<RecyclerView>(R.id.wishlistRecyclerV)
        val nameEt = findViewById<EditText>(R.id.nameEt)
        val priceEt = findViewById<EditText>(R.id.priceEt)
        val URLEt = findViewById<EditText>(R.id.URLEt)
        val SubmitB = findViewById<Button>(R.id.SubmitB)
        // Create adapter passing in the wishlist
        val adapter = WishlistAdapter(wishlistItems)
        // Attach the adapter to the RecyclerView to populate items
        wishlistRecyclerV.adapter = adapter
        // Set layout manager to position the items
        wishlistRecyclerV.layoutManager = LinearLayoutManager(this)
        SubmitB.setOnClickListener{
            val item = nameEt.text.toString()
            val URL = URLEt.text.toString()
            val price = priceEt.text.toString()
            //use the data model to get wishlist items
            val wishItems = Wishlist(item,URL,price)
            //add wish items to the list
            wishlistItems.add(wishItems)

            adapter.notifyItemInserted(wishlistItems.size - 1)

        }
    }
}
