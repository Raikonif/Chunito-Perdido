package com.dai

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.dai.petsearcher.R
import java.util.*


class DatePickerFragment(val listener: (day: Int, month: Int, year: Int, hour: Int, minutes: Int) -> Unit) : DialogFragment(),DatePickerDialog.OnDateSetListener {

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)

        val calendar = Calendar.getInstance()
    }
}