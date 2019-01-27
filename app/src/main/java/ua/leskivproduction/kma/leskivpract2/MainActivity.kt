package ua.leskivproduction.kma.leskivpract2

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private val logTag = MainActivity::class.java.simpleName
    private val textRequest = 1
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView
    private lateinit var mMessageEditText: EditText

    companion object {
        const val extraMessage = "ua.leskivproduction.kma.leskivpract2.extra.MESSAGE"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
    }

    fun launchSecondActivity(view: View) {
        Log.d(logTag, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText.text.toString()
        intent.putExtra(extraMessage, message)
        startActivityForResult(intent, textRequest)
    }

    public override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == textRequest) {
            if (resultCode == Activity.RESULT_OK) {
                val reply = data!!.getStringExtra(SecondActivity.extraReply)
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }
}
