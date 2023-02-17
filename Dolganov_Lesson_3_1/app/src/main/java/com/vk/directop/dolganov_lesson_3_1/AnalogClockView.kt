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

        drawCircle(canvas)

        paint.strokeWidth = 10f
        canvas?.drawLine(width / 2f, height / 2f, 60f, 50f, paint)

        paint.color = Color.BLUE
        paint.strokeWidth = 30f

        canvas?.drawLine(300f, 300f, width/2f, height/2f, paint)
    }

    fun drawCircle(canvas: Canvas?){
        val w = (width/2).toFloat()
        val h = (height/2).toFloat()

        canvas?.drawCircle(w,h,300f,paint)
    }
}
