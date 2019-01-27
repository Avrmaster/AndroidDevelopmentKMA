package ua.leskivproduction.kma.hellocompat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*
import android.support.v4.content.ContextCompat


class MainActivity : AppCompatActivity() {

    // Text view for Hello World.
    private lateinit var mHelloTextView: TextView
    // array of color names, these match the color resources in color.xml
    private val mColorArray = arrayOf(
        "red",
        "pink",
        "purple",
        "deep_purple",
        "indigo",
        "blue",
        "light_blue",
        "cyan",
        "teal",
        "green",
        "light_green",
        "lime",
        "yellow",
        "amber",
        "orange",
        "deep_orange",
        "brown",
        "grey",
        "blue_grey",
        "black"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mHelloTextView = findViewById(R.id.hello_textview)
        // restore saved instance state (the text color)
        if (savedInstanceState != null)
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"))
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // save the current text color
        outState.putInt("color", mHelloTextView.currentTextColor)
    }

    fun changeColor(view: View) {
        val random = Random()
        val colorName = mColorArray[random.nextInt(20)]
        val colorResourceName = resources.getIdentifier(
            colorName,
            "color", applicationContext.packageName
        )
        val colorRes = ContextCompat.getColor(this, colorResourceName)
        mHelloTextView.setTextColor(colorRes)
    }

}
