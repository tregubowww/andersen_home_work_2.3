package ru.tregubowww.andersen_home_work_2_3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var  mReply: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mReply = findViewById(R.id.editText_second)

        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
    }

    fun returnReply(view: View?) {
        val reply = mReply.text.toString()

        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    companion object {
        const val EXTRA_REPLY = "ru.tregubowww.andersen_home_work_2_3.extra.REPLY"
    }
}