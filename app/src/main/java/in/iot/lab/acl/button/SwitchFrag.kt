package `in`.iot.lab.acl.button

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class SwitchFrag : Fragment() {
    lateinit var code: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_switch, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
    <Switch
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Switch1:"
        android:checked="true"
        android:textOff="OFF"
        android:textOn="ON"
        android:id="@+id/Switch"
        android:layout_gravity="center"
        tools:ignore="UseSwitchCompatOrMaterialXml" />
    ```
    #Kotlin
    ```kotlin
    val switch=findViewById<Switch>(R.id.Switch)
    //To Set button and do other action
    switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // The toggle is enabled
            } else {
                // The toggle is disabled
            }
        })
    ```
""".trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }

}