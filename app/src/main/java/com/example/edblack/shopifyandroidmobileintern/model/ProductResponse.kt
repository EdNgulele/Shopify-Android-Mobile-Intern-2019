package com.example.edblack.shopifyandroidmobileintern.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose



data class ProductResponse(@SerializedName("products") val products: List<Product>)
