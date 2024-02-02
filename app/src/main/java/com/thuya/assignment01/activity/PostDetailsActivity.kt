package com.thuya.assignment01.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thuya.assignment01.databinding.ActivityPostDetailsBinding
import com.thuya.assignment01.model.PostItem

class PostDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnBack.setOnClickListener{
            finish()
        }

        val item = intent.getSerializableExtra("post-item") as PostItem

        binding.postTitle.text = item.title
        binding.postDetails.text = item.body
    }
}