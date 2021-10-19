package `in`.iot.lab.acl.SubAdvanced

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.iot.lab.acl.R
import android.app.Activity
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import io.noties.markwon.Markwon
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class fragment_adv__sub__MotionToast : Fragment() {
    lateinit var button_toast: Button
    lateinit var code_mt: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_adv__sub___motion_toast, container, false)

        code_mt = view.findViewById(R.id.code_mt)
        button_toast = view.findViewById(R.id.button_toast)

        button_toast.setOnClickListener {
            MotionToast.createColorToast(context as Activity,
                "Android Component Library",
                "This toast shows information about Motion Toast",
                MotionToastStyle.INFO,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(context as Activity, R.font.helvetica_regular))
        }

        val md = """
            #Gradle
            ```
            implementation 'com.github.Spikeysanju:MotionToast:1.4'
            ```
            #Kotlin
            ```kotlin
             MotionToast.createColorToast(context as Activity,
                "Android Component Library",
                "This toast shows information about Motion Toast",
                MotionToastStyle.INFO,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(context as Activity, R.font.helvetica_regular))
            ```
            #Github Link
            ```text
            https://github.com/Spikeysanju/MotionToast
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code_mt, md)

        return view
    }
}