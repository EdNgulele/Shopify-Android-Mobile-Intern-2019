package com.example.edblack.shopifyandroidmobileintern.interaction

import com.example.edblack.shopifyandroidmobileintern.api.ShopifyApiService
import com.example.edblack.shopifyandroidmobileintern.common.TOKEN
import com.example.edblack.shopifyandroidmobileintern.model.ProductResponse
import retrofit2.Callback

class ShopifyInteractor(private val apiService: ShopifyApiService) : ShopifyInteractorInterface {

    override fun getProductTags(callback: Callback<ProductResponse>) {
        apiService.getProductTags(TOKEN).enqueue(callback)
    }

}