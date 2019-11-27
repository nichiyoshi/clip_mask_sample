package com.example.nichiyoshi.maskclipsample

import android.graphics.Rect
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.observe

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            viewModel.requestViewToClip()
        }

        viewModel.viewToClip.observe(this) { targetView ->
            Rect().apply {
                targetView.getDrawingRect(this)
                container.offsetDescendantRectToMyCoords(targetView, this)
                mask.clipWithRect(this)
            }
        }
    }
}
