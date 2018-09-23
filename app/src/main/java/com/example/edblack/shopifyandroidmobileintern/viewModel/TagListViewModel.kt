package com.example.edblack.shopifyandroidmobileintern.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.edblack.shopifyandroidmobileintern.App
import com.example.edblack.shopifyandroidmobileintern.model.Product
import com.example.edblack.shopifyandroidmobileintern.model.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TagListViewModel : ViewModel() {

    private val interactor by lazy { App.component.ShopifyInteractor() }

    val errorData = MutableLiveData<Boolean>()
    val loadingData = MutableLiveData<Boolean>()


    val tagListData = MutableLiveData<List<Product>>()




    fun getTagList() {
        interactor.getProductTags(TagListCallback())
    }

    fun onRefresh() {
        getTagList()
    }

    private fun TagListCallback() = object : Callback<ProductResponse> {
        override fun onFailure(call: Call<ProductResponse>?, t: Throwable?) {
            errorData.value = true
            loadingData.value = false
        }

        override fun onResponse(call: Call<ProductResponse>?, response: Response<ProductResponse>?) {
            errorData.value = false
            loadingData.value = false

            response?.body()?.run {
                updateData(this)
            }
        }

    }

    private fun updateData(data: ProductResponse) {
        tagListData.value = data.products
    }

}