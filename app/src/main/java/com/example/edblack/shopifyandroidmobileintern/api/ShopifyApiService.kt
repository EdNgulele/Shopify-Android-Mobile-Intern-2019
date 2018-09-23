package com.example.edblack.shopifyandroidmobileintern.api

import com.example.edblack.shopifyandroidmobileintern.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopifyApiService {

    @GET("products.json")
    fun getProductTags(@Query("access_token") apiKey: String): Call<ProductResponse>
}