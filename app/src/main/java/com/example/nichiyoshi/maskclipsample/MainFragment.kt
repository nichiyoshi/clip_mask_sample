package com.example.nichiyoshi.maskclipsample

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import coil.api.load
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment(R.layout.fragment_main) {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image1.scaleType = ImageView.ScaleType.FIT_CENTER
        image2.scaleType = ImageView.ScaleType.FIT_CENTER

        // loads images from free image provider "pakutaso"
        image1.load("https://www.pakutaso.com/shared/img/thumb/cat9302341_TP_V.jpg")
        image2.load("https://www.pakutaso.com/shared/img/thumb/cat9302331_TP_V.jpg")

        viewModel.requestViewToClip.observe(viewLifecycleOwner) {
            viewModel.setViewToCLip(image1)
        }
    }

}