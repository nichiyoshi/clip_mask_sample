package com.example.nichiyoshi.maskclipsample

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _viewToClip = MutableLiveData<View>()
    val viewToClip: LiveData<View> = _viewToClip

    fun setViewToCLip(view: View) {
        _viewToClip.postValue(view)
    }

    private val _requestViewToClip = MutableLiveData<Unit>()
    val requestViewToClip: LiveData<Unit> = _requestViewToClip

    fun requestViewToClip() {
        _requestViewToClip.postValue(Unit)
    }

}