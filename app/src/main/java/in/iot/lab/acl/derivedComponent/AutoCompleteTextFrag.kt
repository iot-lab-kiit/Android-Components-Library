package `in`.iot.lab.acl.derivedComponent

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class AutoCompleteTextFrag : Fragment() {
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var txtautotext: TextView
    var nameList = arrayOf(
        "Abhishek",
        "Anad",
        "Anurag",
        "Avni",
        "Bindiya",
        "Bunny",
        "Ban",
        "Chandni",
        "Champ",
        "Charu",
        "Dax",
        "Dhruva",
        "Milan",
        "Mayur",
        "Mohit",
        "Payal",
        "Priti",
        "Prachi",
        "Kajal",
        "Krisha",
        "Kriva",
        "Kishan",
        "Kaushik",
        "Hetal",
        "Hina",
        "Rahul",
        "Rutvi",
        "Rutvik",
        "Sneha",
        "Shreya",
        "Sarika",
        "Zen"
    )

    lateinit var codeView: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView =
            inflater.inflate(R.layout.fragment_auto_complete_text, container, false)

        autoCompleteTextView=myFragmentView.findViewById(R.id.AutoCompleteTextViewDemo)
        txtautotext=myFragmentView.findViewById(R.id.txtautotext)

        val editText = StringBuilder()
        editText.append("Input Value:").append("\n")
        for (value in nameList) {
            editText.append(value).append(", ")
        }
        txtautotext.text = editText
        val arrayAdapter= ArrayAdapter(requireContext(),android.R.layout.simple_expandable_list_item_1,nameList)
        autoCompleteTextView.setAdapter(arrayAdapter);


        codeView = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            #XML
            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical"
                tools:context=".derivedComponent.AutoCompleteTextFrag">
                <AutoCompleteTextView
                    android:id="@+id/AutoCompleteTextViewDemo"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_margin="20dp"
                    android:hint="Enter Name"
                    android:padding="15dp"
                    android:textColor="@color/black" />
                <TextView
                    android:id="@+id/txtautotext"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginLeft="20dp"
                    android:layout_marginRight="20dp" />
            </LinearLayout>
            ```             
            #Kotlin
            ```kotlin
            lateinit var autoCompleteTextView: AutoCompleteTextView
            lateinit var txtautotext: TextView
            var nameList = arrayOf(
            "Abhishek","Anad","Anurag","Avni","Bindiya","Bunny","Ban","Chandni",
            "Champ","Charu","Dax","Dhruva","Milan","Mayur","Mohit","Payal",
            "Priti","Prachi","Kajal","Krisha","Kriva","Kishan","Kaushik",
            "Hetal","Hina","Rahul","Rutvi","Rutvik","Sneha","Shreya",
            "Sarika","Zen")
            
            autoCompleteTextView=myFragmentView.findViewById(R.id.AutoCompleteTextViewDemo)
            txtautotext=myFragmentView.findViewById(R.id.txtautotext)

            val editText = StringBuilder()
            editText.append("Input Value:").append("\n")
            for (value in nameList) {
                editText.append(value).append(", ")
            }
            txtautotext.text = editText
            val arrayAdapter= ArrayAdapter(requireContext(),android.R.layout.simple_expandable_list_item_1,nameList)
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setThreshold(1);//start searching from 1 character
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(codeView, md)


        return myFragmentView
    }


}