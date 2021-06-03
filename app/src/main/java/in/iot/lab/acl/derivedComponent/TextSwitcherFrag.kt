package `in`.iot.lab.acl.derivedComponent

import `in`.iot.lab.acl.R
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class TextSwitcherFrag : Fragment() {
    lateinit var txtSwitcher: TextSwitcher
    lateinit var btntxtswtnxt: Button
    lateinit var btntxtswtpre: Button
    var strTextSwitcher = arrayOf(
        "Text Switcher 1",
        "Text Switcher 2",
        "Text Switcher 3",
        "Text Switcher 4",
        "Text Switcher 5"
    )
    var index = 0

    lateinit var codeView: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_text_switcher, container, false)
        txtSwitcher = myFragmentView.findViewById(R.id.TextSwitcherDemo)
        btntxtswtnxt = myFragmentView.findViewById(R.id.btntxtswtnext)
        btntxtswtpre = myFragmentView.findViewById(R.id.btntxtswtpre)

        // accessing the TextSwitcher from XML layout
        txtSwitcher.setFactory {
            val textView = TextView(requireContext())
            textView.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            textView.textSize = 32f
            textView.setTextColor(Color.BLUE)
            textView
        }
        txtSwitcher.setText(strTextSwitcher[index])

        val textIn = AnimationUtils.loadAnimation(
            requireContext(), android.R.anim.slide_in_left
        )
        txtSwitcher.inAnimation = textIn

        val textOut = AnimationUtils.loadAnimation(
            requireContext(), android.R.anim.slide_out_right
        )
        txtSwitcher.outAnimation = textOut

        // previous button functionality
        btntxtswtpre.setOnClickListener {
            index = if (index - 1 >= 0) index - 1 else 4
            txtSwitcher.setText(strTextSwitcher[index])
        }
        // next button functionality
        btntxtswtnxt.setOnClickListener {
            index = if (index + 1 < strTextSwitcher.size) index + 1 else 0
            txtSwitcher.setText(strTextSwitcher[index])
        }


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
                tools:context=".derivedComponent.TextSwitcherFrag">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="100dp">
    
                    <TextSwitcher
                        android:id="@+id/TextSwitcherDemo"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:layout_marginTop="50dp" />
                </LinearLayout>

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:gravity="center"
                    android:orientation="horizontal">

                    <Button
                        android:id="@+id/btntxtswtpre"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:padding="10dp"
                        android:text="Previous"
                        android:textColor="#fff"
                        android:textStyle="bold" />

                    <Button
                        android:id="@+id/btntxtswtnext"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_marginLeft="20dp"
                        android:text="NEXT"
                        android:textColor="#fff"
                        android:textStyle="bold" />
                </LinearLayout>

            </LinearLayout>
            ```
            #Kotlin
            ```kotlin
            lateinit var txtSwitcher: TextSwitcher
            lateinit var btntxtswtnxt: Button
            lateinit var btntxtswtpre:Button
            var strTextSwitcher = arrayOf(
                "Text Switcher 1",
                "Text Switcher 2",
                "Text Switcher 3",
                "Text Switcher 4",
                "Text Switcher 5"
            )
            var index = 0
    
            txtSwitcher=myFragmentView.findViewById(R.id.TextSwitcherDemo)
            btntxtswtnxt=myFragmentView.findViewById(R.id.btntxtswtnext)
            btntxtswtpre=myFragmentView.findViewById(R.id.btntxtswtpre)

            // accessing the TextSwitcher from XML layout
            txtSwitcher.setFactory {
                val textView = TextView(requireContext())
                textView.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
                textView.textSize = 32f
                textView.setTextColor(Color.BLUE)
                textView
            }
            txtSwitcher.setText(strTextSwitcher[index])

            val textIn = AnimationUtils.loadAnimation(
                requireContext(), android.R.anim.slide_in_left)
                txtSwitcher.inAnimation = textIn

            val textOut = AnimationUtils.loadAnimation(
                requireContext(), android.R.anim.slide_out_right)
                txtSwitcher.outAnimation = textOut

            // previous button functionality
            btntxtswtpre.setOnClickListener {
                index = if (index - 1 >= 0) index - 1 else 4
                txtSwitcher.setText(strTextSwitcher[index])
            }
            // next button functionality
            btntxtswtnxt.setOnClickListener {
                index = if (index + 1 < strTextSwitcher.size) index + 1 else 0
                txtSwitcher.setText(strTextSwitcher[index])
            }
           ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(codeView, md)
        return myFragmentView
    }


}