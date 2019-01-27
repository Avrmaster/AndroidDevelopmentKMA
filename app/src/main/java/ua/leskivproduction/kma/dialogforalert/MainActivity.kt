package ua.leskivproduction.kma.dialogforalert

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickShowAlert(view: View) {
        val myAlertBuilder = AlertDialog.Builder(this@MainActivity)
        myAlertBuilder.setTitle("Alert")
        myAlertBuilder.setMessage("Click OK to continue, or Cancel to stop:")
        myAlertBuilder.setPositiveButton("OK") { _, _ ->
            // User clicked OK button.
            Toast.makeText(
                applicationContext, "Pressed OK",
                Toast.LENGTH_SHORT
            ).show()
        }
        myAlertBuilder.setNegativeButton("Cancel") { _, _ ->
            // User cancelled the dialog.
            Toast.makeText(
                applicationContext, "Pressed Cancel",
                Toast.LENGTH_SHORT
            ).show()
        }
        myAlertBuilder.show()
    }

}
