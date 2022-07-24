package com.softwork.ageinminutes

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateBtn = findViewById<Button>(R.id.dateBtn)

        dateBtn.setOnClickListener{ view ->
            clickDatePicker(view)
            //Toast.makeText(this, "Button Works", Toast.LENGTH_LONG).show()
        }
    }
    fun clickDatePicker(view: View){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(this, "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear", Toast.LENGTH_LONG).show()
            val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

            val selectedDateTV = findViewById<TextView>(R.id.selectedDateTV)
            selectedDateTV.setText(selectedDate)
            
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val parsedDateFormat = simpleDateFormat.parse(selectedDate)

                                                                 }, year, month, day).show()
    }

}