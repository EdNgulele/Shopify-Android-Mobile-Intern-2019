package com.example.edblack.shopifyandroidmobileintern.ui.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.edblack.shopifyandroidmobileintern.model.Product
import kotlinx.android.synthetic.main.item_tag.view.*

class TagListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun showTagList(product: Product): Unit = with(itemView) {
        tv_product_tag.text = product.tag
    }
}