package com.example.nichiyoshi.maskclipsample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MaskView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val backgroundPaint = Paint().apply {
        color = Color.parseColor("#80000000")
    }

    private val clearPaint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    private var clipRect: Rect? = null

    fun clipWithRect(rect: Rect) {
        clipRect = rect
        postInvalidate()
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        setLayerType(LAYER_TYPE_HARDWARE, null)

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

        clipRect?.let { rect ->
            canvas.drawRect(rect, clearPaint)
        }
    }

}