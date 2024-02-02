package com.thuya.assignment01.model

import java.io.Serializable

data class PostItem(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) : Serializable