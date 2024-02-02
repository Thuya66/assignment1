package com.thuya.assignment01.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thuya.assignment01.R
import com.thuya.assignment01.model.PostItem
import com.thuya.assignment01.model.PostX

class PostAdapter(private val postList: PostX, private val itemClickListener: (PostItem) -> Unit):RecyclerView.Adapter<PostAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val post:PostItem = postList[position]

        // sets the text to the textview from our itemHolder class
        holder.title.text = post.title

        holder.itemView.setOnClickListener{
            itemClickListener(post)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return postList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: TextView = itemView.findViewById(R.id.post_title)
    }
}