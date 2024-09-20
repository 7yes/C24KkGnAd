package com.jesse.c24kkgnad.g2

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.jesse.c24kkgnad.R
import com.jesse.c24kkgnad.databinding.FragmentDayPickerBinding
import com.jesse.c24kkgnad.databinding.FragmentLayoutCoinstrainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DayPickerFragment : Fragment() {

    private var _binding: FragmentDayPickerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDayPickerBinding.inflate(layoutInflater, container, false)
        binding.etDay.setOnClickListener { showDatePickerDialog() }
        return binding.root
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFrag { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(parentFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        binding.etDay.setText("$month/$day/$year")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

/// otra clase
class DatePickerFrag(val listener: (day: Int, month: Int, year: Int) -> Unit) : DialogFragment(),
    DatePickerDialog.OnDateSetListener {

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context, this, year, month, day)
        picker.datePicker.minDate = c.timeInMillis
        picker.datePicker.maxDate = c.timeInMillis + 3*86400000
        return picker
    }

}