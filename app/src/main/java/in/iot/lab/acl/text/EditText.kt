package `in`.iot.lab.acl.text

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon

class EditText : Fragment() {

    lateinit var codeView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView=inflater.inflate(R.layout.fragment_edit_text, container, false)

        codeView = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            #XML
            ```xml
            <EditText
                android:padding="20dp"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:id="@+id/editText"
                android:hint="Enter Test here"
                android:textAlignment="center"/>
            ```
            #Kotlin
            ```kotlin
            val editText=findViewById<EditText>(R.id.editText)
            //To get test from EDIT TEXT
            val text=editText.text
            //To Set Text
            editText.text="Text To Be Set"
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(codeView, md)
        return myFragmentView
    }
}