package ru.tregubowww.andersen_home_work_2_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var   mMessageEditText: EditText
    private lateinit var   mReplyHeadTextView: TextView
    private lateinit var  mReplyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    fun launchSecondActivity(view: View?) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)

                mReplyHeadTextView.visibility = View.VISIBLE

                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        val LOG_TAG: String = MainActivity::class.java.simpleName
        const val EXTRA_MESSAGE = "ru.tregubowww.andersen_home_work_2_3.extra.MESSAGE"
        const val TEXT_REQUEST = 1
    }
}