package com.example.nichiyoshi.maskclipsample

import android.graphics.Rect
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.observe

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            viewModel.requestRectToClip()
        }

        viewModel.clipRectOfDescendant.observe(this) {targetView ->
            Rect().apply {
                targetView.getDrawingRect(this)
                container.offsetDescendantRectToMyCoords(targetView, this)
                mask.clipWithRect(this)
            }
        }
    }
}
