package com.example.nichiyoshi.maskclipsample

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _clipRectOfDescendant = MutableLiveData<View>()
    val clipRectOfDescendant: LiveData<View> = _clipRectOfDescendant

    fun requestClipWithRect(view: View) {
        _clipRectOfDescendant.postValue(view)
    }

    private val _rectToClip = MutableLiveData<Unit>()
    val requestRectToClip: LiveData<Unit> = _rectToClip

    fun requestRectToClip() {
        _rectToClip.postValue(Unit)
    }

}