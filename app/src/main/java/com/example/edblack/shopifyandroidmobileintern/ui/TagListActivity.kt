package com.example.edblack.shopifyandroidmobileintern.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.edblack.shopifyandroidmobileintern.R
import com.example.edblack.shopifyandroidmobileintern.common.getViewModel
import com.example.edblack.shopifyandroidmobileintern.common.subscribe
import com.example.edblack.shopifyandroidmobileintern.ui.adapter.TagListAdapter
import com.example.edblack.shopifyandroidmobileintern.viewModel.TagListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class TagListActivity : AppCompatActivity() {


    private val viewModel by lazy { getViewModel<TagListViewModel>() }

    private val tagListAdapter = TagListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()

        viewModel.errorData.subscribe(this, this::setErrorVisibility)
        viewModel.loadingData.subscribe(this, this::showLoading)
        viewModel.tagListData.subscribe(this, tagListAdapter::addItems)

        viewModel.getTagList()

        pullToRefresh.setOnRefreshListener(viewModel::onRefresh)

    }

    private fun initializeUi() {
        rview_tag_list.layoutManager = GridLayoutManager(this, 1)
        rview_tag_list.itemAnimator = DefaultItemAnimator()
        rview_tag_list.adapter = tagListAdapter
    }

    private fun showLoading(isLoading: Boolean) {
        pullToRefresh.isRefreshing = isLoading
    }

    private fun setErrorVisibility(shoudShow: Boolean) {
        errorView.visibility = if (shoudShow) View.VISIBLE else View.GONE
        rview_tag_list.visibility = if (!shoudShow) View.VISIBLE else View.GONE
    }
}
