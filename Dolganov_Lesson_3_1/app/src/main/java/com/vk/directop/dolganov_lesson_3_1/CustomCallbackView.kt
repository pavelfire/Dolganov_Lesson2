package com.vk.directop.dolganov_lesson_3_1

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
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

    var isProgressMode: Boolean = false
        set(value) {
            field = value
            with(binding) {
                if (value) {
                    btnTitle.visibility = INVISIBLE
                    btnSubtitle.visibility = INVISIBLE
                    btnIcon.visibility = INVISIBLE
                    mainProgressBar.visibility = VISIBLE
                } else {
                    btnIcon.visibility = VISIBLE
                    btnTitle.visibility = VISIBLE
                    btnSubtitle.visibility = VISIBLE
                    mainProgressBar.visibility = GONE
                }
            }
        }

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

        val ccvTitle = typedArray.getString(R.styleable.CustomCallbackView_ccvTitle)
        setCcvTitle(ccvTitle)

        val ccvSubtitle = typedArray.getString(R.styleable.CustomCallbackView_ccvSubtitle)
        setCcvSubtitle(ccvSubtitle)

        val ccvImage = typedArray.getDrawable(R.styleable.CustomCallbackView_ccvImage)
        setCcvImage(ccvImage)

        isProgressMode =
            typedArray.getBoolean(R.styleable.CustomCallbackView_isProgressMode, false)

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

    override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState()!!
        val savedState = SavedState(superState)
        savedState.titleText = binding.btnTitle.text.toString()
        savedState.subtitleText = binding.btnSubtitle.text.toString()

        return savedState
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val savedState = state as SavedState
        super.onRestoreInstanceState(savedState.superState)
        binding.btnTitle.text = savedState.titleText
        binding.btnSubtitle.text = savedState.subtitleText
    }

    class SavedState : BaseSavedState {

        var titleText: String? = null
        var subtitleText: String? = null

        constructor(superState: Parcelable) : super(superState)
        constructor(parcel: Parcel) : super(parcel) {
            titleText = parcel.readString()
            subtitleText = parcel.readString()
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeString(titleText)
            out.writeString(subtitleText)
        }

        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<SavedState> = object : Parcelable.Creator<SavedState> {
                override fun createFromParcel(source: Parcel): SavedState {
                    return SavedState(source)
                }

                override fun newArray(size: Int): Array<SavedState?> {
                    return Array(size) { null }
                }

            }
        }
    }
}