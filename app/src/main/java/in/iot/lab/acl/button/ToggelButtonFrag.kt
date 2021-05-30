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


class ToggelButtonFrag : Fragment() {
    lateinit var code: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView= inflater.inflate(R.layout.fragment_toggel_button, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            #XML
            ```xml
            <ToggleButton
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:background="#A100FF"
                android:id="@+id/toggleBtn"
                android:layout_gravity="center"
                android:layout_marginTop="10dp"
                android:textOff="This Text Is Shown When Button Is Set For OFF"
                android:textOn="This Text Is Shown When Button Is Set For ON"
            />
            ```
            #Kotlin
            ```kotlin
            val bttn=findViewById<ToggleButton>(R.id.toggleBtn)
            //To Set button and do other action
            bttn.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
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
        return  myFragmentView
    }


}