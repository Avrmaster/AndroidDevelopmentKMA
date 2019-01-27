package ua.leskivproduction.kma.leskivpract2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ua.leskivproduction.kma.leskivpract2.MainActivity.Companion.extraMessage
import android.widget.TextView
import android.widget.EditText
import android.content.Intent
import android.view.View


class SecondActivity : AppCompatActivity() {

    private lateinit var mReply: EditText

    companion object {
        const val extraReply = "ua.leskivproduction.kma.leskivpract2.extra.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent
        val message = intent.getStringExtra(extraMessage)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message

    }

    fun returnReply(view: View) {
        mReply = findViewById(R.id.editText_second)
        val reply = mReply.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(extraReply, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

}
