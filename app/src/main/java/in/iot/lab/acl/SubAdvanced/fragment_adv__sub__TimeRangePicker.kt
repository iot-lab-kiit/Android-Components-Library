package `in`.iot.lab.acl.SubAdvanced

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import io.noties.markwon.Markwon
import nl.joery.timerangepicker.TimeRangePicker

class fragment_adv__sub__TimeRangePicker : Fragment() {
    lateinit var code_trp: TextView
    lateinit var tv_duration: TextView
    lateinit var time_range_picker: TimeRangePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_adv__sub___time_range_picker, container, false)

        code_trp = view.findViewById(R.id.code_trp)
        tv_duration = view.findViewById(R.id.duration)
        time_range_picker = view.findViewById(R.id.time_range_picker)

        time_range_picker.setOnTimeChangeListener(object : TimeRangePicker.OnTimeChangeListener {
            override fun onStartTimeChange(startTime: TimeRangePicker.Time) {
                Log.d("TimeRangePicker", "Start time: " + startTime)
            }

            override fun onEndTimeChange(endTime: TimeRangePicker.Time) {
                Log.d("TimeRangePicker", "End time: " + endTime.hour)
            }

            override fun onDurationChange(duration: TimeRangePicker.TimeDuration) {
                Log.d("TimeRangePicker", "Duration: " + duration.hour)
                val duration_text = "Duration is: ${duration.hour}:${duration.minute}"
                tv_duration.text = duration_text
            }
        })

        val md = """
            #XML
            ```xml
            <nl.joery.timerangepicker.TimeRangePicker
                android:id="@+id/time_range_picker"
                android:layout_width="250dp"
                android:layout_height="250dp"
                android:layout_marginTop="24dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textView4"
                app:trp_endTime="6:30"
                app:trp_startTime="22:00" />
            ```
            #Gradle
            ```
            implementation 'nl.joery.timerangepicker:timerangepicker:1.0.0'
            ```
            #Kotlin
            ```kotlin
            time_range_picker.setOnTimeChangeListener(object : TimeRangePicker.OnTimeChangeListener {
                override fun onStartTimeChange(startTime: TimeRangePicker.Time) {
                    Log.d("TimeRangePicker", "Start time: " + startTime)
                }
    
                override fun onEndTimeChange(endTime: TimeRangePicker.Time) {
                    Log.d("TimeRangePicker", "End time: " + endTime.hour)
                }
    
                override fun onDurationChange(duration: TimeRangePicker.TimeDuration) {
                    Log.d("TimeRangePicker", "Duration: " + duration.hour)
                    val duration_text = "Duration is: ${'$'}{duration.hour}:${'$'}{duration.minute}"
                    tv_duration.text = duration_text
                }
            })
            ```
            #Github Link
            ```text
            https://github.com/Droppers/TimeRangePicker
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code_trp, md)

        return view
    }

}