package `in`.iot.lab.acl.button

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.iot.lab.acl.R
import android.widget.TextView
import io.noties.markwon.Markwon


class CheckboxFrag : Fragment() {
    lateinit var code: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView= inflater.inflate(R.layout.fragment_checkbox, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
    <CheckBox
        android:id="@+id/simpleCheckBox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Simple CheckBox" 
        android:checked="true"/>
    ```
    #Kotlin
    ```kotlin
    val checkBox=findViewById<CheckBox>(R.id.simpleCheckBox)
    //To Set button and do other action
    simpleCheckBox.setChecked(false)
    val checkBoxState = simpleCheckBox.isChecked()
    ```
    """.trimIndent()



        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}