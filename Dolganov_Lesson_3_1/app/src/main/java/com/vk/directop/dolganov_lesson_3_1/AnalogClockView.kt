package com.vk.directop.dolganov_lesson_3_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class AnalogClockView
@JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawClockFace(canvas)

        paint.strokeWidth = 10f
        canvas?.drawLine(width / 2f, height / 2f, 60f, 50f, paint)

        paint.color = Color.BLUE
        paint.strokeWidth = 30f

        canvas?.drawLine(300f, 300f, width / 2f, height / 2f, paint)
    }

    private fun drawClockFace(canvas: Canvas?) {
        val w = (width / 2).toFloat()
        val h = (height / 2).toFloat()
        val radius = if (height >= width) width / 2.5f else height / 2.5f
        val pointLength = 50

        paint.strokeWidth = 20f
        canvas?.drawCircle(w, h, radius, paint)

        paint.strokeWidth = 20f
        canvas?.drawLine(w + radius - pointLength, h, w + radius, h, paint)
        canvas?.drawLine(w - radius + pointLength, h, w - radius, h, paint)
        canvas?.drawLine(w, h + radius - pointLength, w, h + radius, paint)
        canvas?.drawLine(w, h - radius + pointLength, w, h - radius, paint)

        //canvas?.drawLine(w, h - radius + pointLength, w, h - radius, paint)



    }
}
