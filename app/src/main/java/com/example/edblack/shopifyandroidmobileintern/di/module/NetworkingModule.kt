package com.example.edblack.shopifyandroidmobileintern.di.module

import com.example.edblack.shopifyandroidmobileintern.api.ShopifyApiService
import com.example.edblack.shopifyandroidmobileintern.common.BASE_URl
import com.example.edblack.shopifyandroidmobileintern.di.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@ApplicationScope
class NetworkingModule {

    @Provides
    fun provideBaseUrl(): String = BASE_URl

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()

    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRetrofitClient(client: OkHttpClient,
                              baseUrl: String,
                              converter: GsonConverterFactory): Retrofit =
            Retrofit.Builder()
                    .client(client)
                    .addConverterFactory(converter)
                    .baseUrl(baseUrl)
                    .build()

    @Provides
    fun provideShopifyApiService(retrofit: Retrofit): ShopifyApiService =
            retrofit.create(ShopifyApiService::class.java)
}