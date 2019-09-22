package com.muaythaivideoclips.aboutme

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private var binding: com.muaythaivideoclips.aboutme.databinding.ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.done_Button.setOnClickListener {
            addNickname(it)
        }
        binding.nickname_text.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun updateNickname (view: View) {
        val editText = binding.nickname_edit
        val nicknameTextView = binding.done_button
        editText.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE

        val doneButton = binding.done_button
        doneButton.visibility = View.VISIBLE

        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

    @SuppressLint("ServiceCast")
    private fun addNickname(view: View) {
        val editText = binding.nickname_edit
        val nicknameTextView = binding.nickname_text
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val doneButton = binding.R.id.done_button
        doneButton.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

}
