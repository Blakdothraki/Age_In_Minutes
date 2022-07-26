package com.softwork.ageinminutes

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openDateTimePicker(view: View) {
        val c = Calendar.getInstance()

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, yyyy, MM, dd ->
            var dt = "$dd/${MM + 1}/$yyyy"
            val editDateAndTime = findViewById<TextView>(R.id.editDateAndTime)
            //editDateAndTime.setText(dt)
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, HH, Min -> dt += " $HH:$Min"
            editDateAndTime.setText(dt)
            }, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), false).show()

        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
    }

   fun calculateAge(view: View) {
        var today = Date()
       val editDateAndTime = findViewById<TextView>(R.id.editDateAndTime)
        var dobs = editDateAndTime.text.toString()
        var sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
        var parsedDob: Date = sdf.parse(dobs)
        var days = (today.time - (parsedDob.time))/86_400_000
        var hours = (today.time - parsedDob.time)%86_400_000/3_600_000
        var minutes = (today.time - parsedDob.time)%86_400_000%3_600_000/60_000
        var secs = (today.time - parsedDob.time)%86_400_000%3_600_000%60_000/1_000

       val textView = findViewById<TextView>(R.id.textView)
       textView.visibility = View.VISIBLE
        textView.setText("Days = $days\nHours = $hours\nMinutes = $minutes\nSeconds = $secs")
    }
}