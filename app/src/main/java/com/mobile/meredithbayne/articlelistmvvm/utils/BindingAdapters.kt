package com.mobile.meredithbayne.articlelistmvvm.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.mobile.meredithbayne.articlelistmvvm.utils.extension.getParentActivity

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parent: AppCompatActivity? = view.getParentActivity()

    if (parent != null && visibility != null) {
        visibility.observe(parent, Observer { value -> view.visibility = value?:View.VISIBLE })
    }
}