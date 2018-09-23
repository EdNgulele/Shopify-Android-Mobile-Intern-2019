package com.example.edblack.shopifyandroidmobileintern.interaction

import com.example.edblack.shopifyandroidmobileintern.model.ProductResponse
import retrofit2.Callback

interface ShopifyInteractorInterface{
    fun getProductTags(callback: Callback<ProductResponse>)
}