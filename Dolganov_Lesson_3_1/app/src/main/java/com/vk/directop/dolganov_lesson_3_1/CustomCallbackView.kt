package com.vk.directop.dolganov_lesson_3_1

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import com.vk.directop.dolganov_lesson_3_1.databinding.CustomButtonBinding

enum class OnCustomCallbackViewAction {
    PUSH
}

typealias OnCustomCallbackViewActionListener = (OnCustomCallbackViewAction) -> Unit

class CustomCallbackView
@JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private val binding: CustomButtonBinding

    private var listener: OnCustomCallbackViewActionListener? = null


    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.custom_button, this, true)
        binding = CustomButtonBinding.bind(this)
        initializeAttributes(attrs, defStyleAttr)
        initListeners()
    }

    private fun initializeAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        if (attrs == null) return
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCallbackView)

        with(binding) {
            val ccvTitle = typedArray.getString(R.styleable.CustomCallbackView_ccvTitle)
            setCcvTitle(ccvTitle)

            val ccvSubtitle = typedArray.getString(R.styleable.CustomCallbackView_ccvSubtitle)
            setCcvSubtitle(ccvSubtitle)

            val ccvImage = typedArray.getDrawable(R.styleable.CustomCallbackView_ccvImage)
            setCcvImage(ccvImage)

            val isProgressMode =
                typedArray.getBoolean(R.styleable.CustomCallbackView_ccvProgressBar, false)
            if (isProgressMode) {
                btnTitle.visibility = INVISIBLE
                btnSubtitle.visibility = INVISIBLE
                mainProgressBar.visibility = VISIBLE
            } else {
                btnTitle.visibility = VISIBLE
                btnSubtitle.visibility = VISIBLE
                mainProgressBar.visibility = GONE
            }
        }

        typedArray.recycle()
    }

    private fun initListeners() {
        binding.root.setOnClickListener {
            this.listener?.invoke(OnCustomCallbackViewAction.PUSH)
        }
    }

    fun setListener(listener: OnCustomCallbackViewActionListener?) {
        this.listener = listener
    }

    fun setCcvTitle(text: String?) {
        binding.btnTitle.text = text ?: "Android trainee"
    }

    fun setCcvSubtitle(text: String?) {
        binding.btnSubtitle.text = text ?: "Стажировка по направлению Android"
    }

    fun setCcvImage(drawable: Drawable?) {
        binding.btnIcon.setImageDrawable(
            drawable ?: ResourcesCompat.getDrawable(
                resources,
                R.drawable.a_logo,
                null
            )
        )
    }
}