package com.example.dynamicfragmentdemo

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.Calendar

class DateAndTime : AppCompatActivity() {
    lateinit var btnDatePicker: Button
    lateinit var btnTimePicker: Button
    lateinit var txtDate: EditText
    lateinit var txtTime: EditText
    private var mYear : Int = 0
    private var mMonth : Int = 0
    private var mDay : Int = 0
    private var mHour : Int = 0
    private var mMinute : Int = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_and_time)

    btnDatePicker = findViewById(R.id.dateBtn)
    btnTimePicker = findViewById(R.id.timeBtn)
    txtDate = findViewById(R.id.dateTxt)
    txtTime = findViewById(R.id.timeTxt)

        btnDatePicker.setOnClickListener {
            //get current date
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]

            // launch date picker dialog
            val datePickerDialog = DatePickerDialog(this,
                {view, year, monthOfYear, dayOfMonth
                ->
                    txtDate.setText(
                        dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year
                    )
                },
            mYear, mMonth, mDay
            )
            datePickerDialog.show()
        }
        btnTimePicker.setOnClickListener {
            //get current time
            val c = Calendar.getInstance()
            mHour = c.get(Calendar.HOUR_OF_DAY)
            mMinute = c.get(Calendar.MINUTE)

            //launch time Picker dialog
            val timePickerDialog = TimePickerDialog(this,
                {view, hourOfDay, minute
                    ->
                    var hourOfDay = hourOfDay
                    val AM_PM =
                        if(hourOfDay < 12){
                        "AM"
                        } else{
                            "PM"
                        }
                    if(AM_PM == "PM") hourOfDay -= 12
                    if(AM_PM == "AM") hourOfDay += 12
                    if(minute < 10)
                        txtTime.setText("$hourOfDay:0$minute $AM_PM")
                    else
                        txtTime.setText("$hourOfDay:$minute $AM_PM")
                },mHour, mMinute, true
            )
            timePickerDialog.show()
        }
    }
}