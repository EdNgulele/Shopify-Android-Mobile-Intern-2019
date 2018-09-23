package com.example.edblack.shopifyandroidmobileintern.model

import com.google.gson.annotations.SerializedName


data class Product(
        @SerializedName("tags") val tag: String,
        @SerializedName("title") val title: String,
        @SerializedName("image") val image: Image)