package com.example.edblack.shopifyandroidmobileintern.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.edblack.shopifyandroidmobileintern.R
import com.example.edblack.shopifyandroidmobileintern.model.Product
import com.example.edblack.shopifyandroidmobileintern.ui.holder.TagListHolder

class TagListAdapter : RecyclerView.Adapter<TagListHolder>() {

    private val products = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagListHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_tag, parent, false)

        return TagListHolder(view)

    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: TagListHolder, position: Int) {

        val product = products[position]

        holder?.run { showTagList(product) }


    }

    fun addItems(newTags: List<Product>) {
        products.addAll(newTags)
        notifyDataSetChanged()
    }

    fun clearIfNeeded() {
        products.clear()
    }


}