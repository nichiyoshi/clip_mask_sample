package com.example.nichiyoshi.maskclipsample

import android.graphics.Rect
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _clipRectOfDescendant = MutableLiveData<Pair<View, Rect>>()
    val clipRectOfDescendant: LiveData<Pair<View, Rect>> = _clipRectOfDescendant

    fun requestClipWithRect(pair: Pair<View, Rect>) {
        _clipRectOfDescendant.postValue(pair)
    }

    private val _rectToClip = MutableLiveData<Unit>()
    val requestRectToClip: LiveData<Unit> = _rectToClip

    fun requestRectToClip() {
        _rectToClip.postValue(Unit)
    }

}