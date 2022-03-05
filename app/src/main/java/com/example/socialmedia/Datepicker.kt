package com.example.socialmedia

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class Datepicker : AppCompatActivity() {
    lateinit var btnDatePicker: Button
    lateinit var btnTimePicker:Button
    lateinit var txtDate: TextView
    lateinit var txtTime:TextView
    lateinit var editText: EditText
    lateinit var edtname : EditText
    lateinit var name : TextView
    lateinit var n : TextView

    private var mYear:Int = 0
    private var mMonth:Int = 0
    private var mDay:Int = 0
    private var mHour:Int = 0
    private var mMinute:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datepicker)

        btnDatePicker = findViewById(R.id.btn_date)
        btnTimePicker = findViewById(R.id.btn_time)
        txtDate = findViewById(R.id.in_date)
        txtTime = findViewById(R.id.in_time)
        edtname = findViewById(R.id.in_name)
        name = findViewById(R.id.in_namee)
        n = findViewById(R.id.a)
        n.setOnClickListener{
            name.setText(edtname.text)
        }



        btnDatePicker.setOnClickListener {

// Get Current Date
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]
            val datePickerDialog = DatePickerDialog(this,
                { view, year, monthOfYear, dayOfMonth -> txtDate.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year) }, mYear, mMonth, mDay )
            datePickerDialog.show()
        }

        btnTimePicker.setOnClickListener {


// Get Current Time
            val c = Calendar.getInstance()
            mHour = c[Calendar.HOUR_OF_DAY]
            mMinute = c[Calendar.MINUTE]


// Launch Time Picker Dialog
            val timePickerDialog = TimePickerDialog(this,
                { view, hourOfDay, minute -> var hourOfDay = hourOfDay
                    val AM_PM =
                        if (hourOfDay < 12) {
                            "AM"
                        } else {
                            "PM"
                        }
                    if (AM_PM === "PM") hourOfDay -= 12
                    if (hourOfDay == 0) hourOfDay += 12
                    if (minute < 10)
                        txtTime.setText("$hourOfDay:0$minute $AM_PM")
                    else
                        txtTime.setText("$hourOfDay:$minute $AM_PM")
                }, mHour, mMinute, false
            )
            timePickerDialog.show()
        }
    }
}