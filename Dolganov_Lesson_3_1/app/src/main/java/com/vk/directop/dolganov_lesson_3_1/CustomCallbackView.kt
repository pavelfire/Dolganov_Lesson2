package com.vk.directop.dolganov_lesson_3_1

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.vk.directop.dolganov_lesson_3_1.databinding.CustomButtonBinding

enum class OnCustomCallbackViewAction{
    PUSH, NOTPUSH
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


    init{
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.custom_button, this, true)
        binding = CustomButtonBinding.bind(this)
        initializeAttributes(attrs, defStyleAttr)
        initListeners()
    }

    private fun initializeAttributes(attrs: AttributeSet?, defStyleAttr: Int){
        if (attrs == null) return
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCallbackView)

        with(binding){
            val ccvTitle = typedArray.getString(R.styleable.CustomCallbackView_ccvTitle)
            btnTitle.text = ccvTitle

            val ccvSubtitle = typedArray.getString(R.styleable.CustomCallbackView_ccvSubtitle)
            btnSubtitle.text = ccvSubtitle

            val ccvImage = typedArray.getDrawable(R.styleable.CustomCallbackView_ccvImage)
            btnIcon.setImageDrawable(ccvImage)

            val isProgressMode = typedArray.getBoolean(R.styleable.CustomCallbackView_ccvProgressBar, false)
            if (isProgressMode){
                btnTitle.visibility = INVISIBLE
                btnSubtitle.visibility = INVISIBLE
                mainProgressBar.visibility = VISIBLE
            }else{
                btnTitle.visibility = VISIBLE
                btnSubtitle.visibility = VISIBLE
                mainProgressBar.visibility = GONE
            }
        }

        typedArray.recycle()
    }

    private fun initListeners(){
        binding.root.setOnClickListener {
            this.listener?.invoke(OnCustomCallbackViewAction.PUSH)
        }
    }
    fun setListener(listener: OnCustomCallbackViewActionListener?){
        this.listener = listener
    }





//    (
//    context: Context,
//    attrs: AttributeSet?,
//    defStyleAttr: Int,
//    defStyleRes: Int
//) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
//        context,
//        attrs,
//        defStyleAttr,
//        0
//    )
//
//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, 0)
//    constructor(context: Context) : this(context, null)
}