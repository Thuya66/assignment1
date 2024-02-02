package com.thuya.assignment01.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thuya.assignment01.adapter.PostAdapter
import com.thuya.assignment01.databinding.ActivityMainBinding
import com.thuya.assignment01.model.PostX
import com.thuya.assignment01.services.ApiServices

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var xPosts = PostX()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val postsList:RecyclerView = binding.postsList

        ApiServices().getPosts(this){ posts ->
            xPosts = posts
            postsList.layoutManager = LinearLayoutManager(this)
            postsList.adapter = PostAdapter(xPosts) { selectedPost ->
                val intent = Intent(this, PostDetailsActivity::class.java)
                intent.putExtra("post-item",selectedPost)
                startActivity(intent)
            }
        }
    }
}