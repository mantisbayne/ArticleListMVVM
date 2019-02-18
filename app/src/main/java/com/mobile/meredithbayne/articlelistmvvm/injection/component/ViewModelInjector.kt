package com.mobile.meredithbayne.articlelistmvvm.injection.component

import com.mobile.meredithbayne.articlelistmvvm.injection.module.NetworkModule
import com.mobile.meredithbayne.articlelistmvvm.ui.PostListViewModel
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}