package com.jesse.c24kkgnad.g2

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.jesse.c24kkgnad.databinding.FragmentTimePickerBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class TimePickerFragment : Fragment() {

    private var _binding: FragmentTimePickerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTimePickerBinding.inflate(layoutInflater, container, false)
        binding.etTime.setOnClickListener {
            showTimePicker()
        }
        return binding.root
    }

    private fun showTimePicker() {
        val timePicker = TimePickerDialogFragment() { hour, minute ->
            onTimeSelected(hour, minute)
        }
        timePicker.show(parentFragmentManager, "timePicker")
    }

    private fun onTimeSelected(hour: Int, minute: Int) {
        binding.etTime.setText("$hour:$minute")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

// otra clase
class TimePickerDialogFragment(val listener: (hour: Int, min: Int) -> Unit) : DialogFragment(),
    TimePickerDialog.OnTimeSetListener {
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        listener(hourOfDay, minute)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c: Calendar = Calendar.getInstance()
        val hour: Int = c.get(Calendar.HOUR_OF_DAY)
        val minute: Int = c.get(Calendar.MINUTE)
        val dialog = TimePickerDialog(activity as Context, this, hour, minute, true)
        return dialog
    }
}