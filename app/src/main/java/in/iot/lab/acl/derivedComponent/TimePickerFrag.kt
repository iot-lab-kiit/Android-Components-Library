package `in`.iot.lab.acl.derivedComponent

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import io.noties.markwon.Markwon

class TimePickerFrag : Fragment() {
    lateinit var codeView: TextView
    lateinit var btnTimePicker: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_alert_dialog, container, false)
        codeView = myFragmentView.findViewById<TextView>(R.id.code)
        btnTimePicker = myFragmentView.findViewById(R.id.btnalrt)

        btnTimePicker.setOnClickListener() {
            openTimePicker()
        }

        val md = """
            #XML
            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <androidx.constraintlayout.widget.ConstraintLayout 
                xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".derivedComponent.TimePickerFrag">

                <Button
                    android:id="@+id/btnTimePicker"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    android:layout_margin="30dp"
                    android:padding="20dp"
                    android:text="Click Here"
                    android:textColor="@color/white"
                    android:textStyle="normal|bold"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toTopOf="parent" />
            
                <TextView
                    android:id="@+id/textView3"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:gravity="center"
                    android:layout_marginTop="16dp"
                    android:text="Click Button to show dialogbox"
                    android:textColor="@color/black"
                    android:textSize="18sp"
                    android:textStyle="normal|bold"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toBottomOf="@+id/btnTimePicker" />
            
            
                <TextView
                    android:id="@+id/code"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="Code"
                    android:layout_marginTop="18dp"
                    android:textColor="@color/black"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toBottomOf="@+id/textView3" />
            </androidx.constraintlayout.widget.ConstraintLayout>
            ```
            #Kotlin
            ```kotlin
            lateinit var codeView: TextView
            lateinit var btnTimePicker: Button
        
            override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                // Inflate the layout for this fragment
                val myFragmentView = inflater.inflate(R.layout.fragment_alert_dialog, container, false)
                codeView = myFragmentView.findViewById<TextView>(R.id.code)
                btnTimePicker = myFragmentView.findViewById(R.id.btnalrt)
        
                btnTimePicker.setOnClickListener() {
                    val isSystem24Hour = is24HourFormat(requireContext())
                    val clockFormat = if (isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H
            
                    val picker = MaterialTimePicker.Builder()
                        .setTimeFormat(clockFormat)
                        .setHour(12)
                        .setMinute(0)
                        .setTitleText("Pick Time")
                        .build()
                    picker.show(childFragmentManager, "Time Picker")
                }
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(codeView, md)

        return myFragmentView
    }

    private fun openTimePicker() {
        val isSystem24Hour = is24HourFormat(requireContext())
        val clockFormat = if (isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H

        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Pick Time")
            .build()
        picker.show(requireActivity().supportFragmentManager, "Time Picker")
    }
}