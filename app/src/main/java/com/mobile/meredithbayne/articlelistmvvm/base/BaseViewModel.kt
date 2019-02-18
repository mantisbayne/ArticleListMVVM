package com.mobile.meredithbayne.articlelistmvvm.base

import android.arch.lifecycle.ViewModel
import com.mobile.meredithbayne.articlelistmvvm.injection.component.DaggerViewModelInjector
import com.mobile.meredithbayne.articlelistmvvm.injection.component.ViewModelInjector
import com.mobile.meredithbayne.articlelistmvvm.injection.module.NetworkModule
import com.mobile.meredithbayne.articlelistmvvm.ui.PostListViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}