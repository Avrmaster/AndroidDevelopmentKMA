package ua.leskivproduction.kma.pickerfordate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDatePicker(view: View) {
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        val monthString = Integer.toString(month + 1)
        val dayString = Integer.toString(day)
        val yearString = Integer.toString(year)
        val dateMessage = "$monthString/$dayString/$yearString"
        Toast.makeText(
            this, "Date: $dateMessage",
            Toast.LENGTH_SHORT
        ).show()
    }

}
