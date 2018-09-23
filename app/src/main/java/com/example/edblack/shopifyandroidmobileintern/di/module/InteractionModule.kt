package com.example.edblack.shopifyandroidmobileintern.di.module

import com.example.edblack.shopifyandroidmobileintern.api.ShopifyApiService
import com.example.edblack.shopifyandroidmobileintern.interaction.ShopifyInteractor
import com.example.edblack.shopifyandroidmobileintern.interaction.ShopifyInteractorInterface
import dagger.Module
import dagger.Provides


@Module(includes = [(NetworkingModule::class)])
class InteractionModule {

    @Provides
    fun provideShopifyInteractor(apiService: ShopifyApiService): ShopifyInteractorInterface =
            ShopifyInteractor(apiService)
}