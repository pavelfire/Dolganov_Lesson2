package com.vk.directop.dolganov_lesson2

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class SecondActivityContract : ActivityResultContract<Unit, String?>() {

    override fun parseResult(resultCode: Int, result: Intent?): String? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }
        return result?.getStringExtra(RESULT_KEY)
    }

    companion object {
        const val RESULT_KEY = "from_edit_text"
    }

    override fun createIntent(context: Context, input: Unit): Intent {
        return Intent(context, SecondActivity::class.java)
    }
}