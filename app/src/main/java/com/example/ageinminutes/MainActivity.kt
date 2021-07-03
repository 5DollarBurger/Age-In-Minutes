package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.ageinminutes.databinding.ActivityMainBinding
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

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->

            },
            year, month, day
        ).show()
    }
}