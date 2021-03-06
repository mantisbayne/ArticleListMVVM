package com.mobile.meredithbayne.articlelistmvvm.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.mobile.meredithbayne.articlelistmvvm.R
import com.mobile.meredithbayne.articlelistmvvm.databinding.ActivityPostListBinding

class PostListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityPostListBinding
    private lateinit var postListViewModel: PostListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_list)
        binding.postList.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)

        postListViewModel = ViewModelProviders.of(this).get(PostListViewModel::class.java)
        binding.viewModel = postListViewModel
    }
}