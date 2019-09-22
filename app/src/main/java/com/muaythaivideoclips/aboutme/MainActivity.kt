package com.muaythaivideoclips.aboutme

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil

class MainActivity(val it: View) : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding(){
    private val myName: MyName = MyName("Parinyakiat Sukprasert")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
           done_Button.setOnClickListener {
                addNickname(it)
            }
            nickname_text.setOnClickListener {
                updateNickname(it)
            }
        }
        this.myName = this@mainActivity.myName
    }

    }

    private fun updateNickname (view: View) {
        binding.apply {
            nickname_edit.visibility = View.VISIBLE
            done_button.visibility = View.GONE

            done_button.visibility = View.VISIBLE

            nickname_edit.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.nickname_edit, 0)
        }
    }
    @SuppressLint("ServiceCast")
    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            nickname_edit.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE
            done_button.visibility = View.GONE
            invalidateALL()
        }
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

}
