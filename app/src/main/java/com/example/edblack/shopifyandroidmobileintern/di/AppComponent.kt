package com.example.edblack.shopifyandroidmobileintern.di

import com.example.edblack.shopifyandroidmobileintern.App
import com.example.edblack.shopifyandroidmobileintern.di.module.InteractionModule
import com.example.edblack.shopifyandroidmobileintern.interaction.ShopifyInteractor
import com.example.edblack.shopifyandroidmobileintern.interaction.ShopifyInteractorInterface
import dagger.Component


@Component(modules = [(InteractionModule::class)])
@ApplicationScope
interface AppComponent{

    fun inject(app: App)

    fun ShopifyInteractor(): ShopifyInteractorInterface

}