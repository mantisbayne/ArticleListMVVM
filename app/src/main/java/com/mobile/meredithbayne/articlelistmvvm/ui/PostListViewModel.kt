package com.mobile.meredithbayne.articlelistmvvm.ui

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.mobile.meredithbayne.articlelistmvvm.base.BaseViewModel
import com.mobile.meredithbayne.articlelistmvvm.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel: BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi

    private lateinit var disposable: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadPosts();
    }

    private fun loadPosts() {
        disposable = postApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { onRetrievePostListSuccess() },
                        { onRetrievePostListError() }
                )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    private fun onRetrievePostListError() {

    }

    private fun onRetrievePostListSuccess() {

    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
    }
}