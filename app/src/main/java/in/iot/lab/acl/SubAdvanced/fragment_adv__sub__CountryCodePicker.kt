package `in`.iot.lab.acl.SubAdvanced

import `in`.iot.lab.acl.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.hbb20.CountryCodePicker
import io.noties.markwon.Markwon

class fragment_adv__sub__CountryCodePicker : Fragment() {
    lateinit var code_ccp: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_adv__sub___country_code_picker, container, false)

        code_ccp = view.findViewById(R.id.code_ccp)

        val ccp = view.findViewById<CountryCodePicker>(R.id.country_code_picker)
        val editTextPhone = view.findViewById<EditText>(R.id.editTextPhone)
        val show_toast_button = view.findViewById<Button>(R.id.show_toast_button)

        show_toast_button.setOnClickListener {
            val code = ccp.selectedCountryCode
            val country = ccp.selectedCountryName
            val number = editTextPhone.text.toString()

            val text = "Country: $country, Code: $code, Number: $number"

            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }

        val md = """
            #XML
            ```xml
            <com.hbb20.CountryCodePicker
                android:id="@+id/country_code_picker"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="48dp"
                android:layout_marginStart="24dp"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textView" />
            ```
            #Gradle
            ```
            implementation 'com.hbb20:ccp:2.5.4'
            ```
            #Kotlin
            ```kotlin
            val ccp = view.findViewById<CountryCodePicker>(R.id.country_code_picker)
            val editTextPhone = view.findViewById<EditText>(R.id.editTextPhone)
            val show_toast_button = view.findViewById<Button>(R.id.show_toast_button)
    
            show_toast_button.setOnClickListener {
                val code = ccp.selectedCountryCode
                val country = ccp.selectedCountryName
                val number = editTextPhone.text.toString()
    
                val text = "Country: ${'$'}country, Code: ${'$'}code, Number: ${'$'}number"
    
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            }
            ```
            #Github Link
            ```text
            https://github.com/hbb20/CountryCodePickerProject
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code_ccp, md)


        return view
    }
}