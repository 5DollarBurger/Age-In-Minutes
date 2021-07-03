package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.ageinminutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        binding.btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
//            Toast.makeText(
//                this,
//                "Button works",
//                Toast.LENGTH_LONG
//            ).show()
        }
    }

    fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->

                // Report input date
                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                binding.tvSelectedDate.setText(selectedDate)

                // Process selected date to datetime object
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)

                // Time number of minutes from reference 1970 to selected date
                val selectedDateInMinutes = theDate!!.time / 60000 // Assuring that not null

                // Time number of minutes from reference 1970 to current date
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDate!!.time / 60000

                // Calculate number of minutes difference
                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                binding.tvSelectedDateinMinutes.setText(differenceInMinutes.toString())
            },
            year, month, day
        )

        // Only past dates allowed to be selected in calendar
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }
}