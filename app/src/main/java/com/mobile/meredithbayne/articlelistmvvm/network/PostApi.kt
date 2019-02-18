package com.mobile.meredithbayne.articlelistmvvm.network

import com.mobile.meredithbayne.articlelistmvvm.model.Post
import retrofit2.http.GET
import io.reactivex.Observable

interface PostApi {
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}