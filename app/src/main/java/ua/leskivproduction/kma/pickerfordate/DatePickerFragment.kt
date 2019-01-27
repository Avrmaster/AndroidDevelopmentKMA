package ua.leskivproduction.kma.pickerfordate

import android.support.v4.app.DialogFragment
import android.app.DatePickerDialog
import android.widget.DatePicker
import android.app.Dialog
import android.os.Bundle
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val activity = activity as MainActivity?
        activity!!.processDatePickerResult(year, month, dayOfMonth)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it.
        return DatePickerDialog(activity!!, this, year, month, day)
    }

}
