package `in`.iot.lab.acl.layouts

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class LinearLayoutH : Fragment() {
    lateinit var code: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_linear_layout_h, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)

        val md = """
            #XML
            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal"
                tools:context=".layouts.LinearLayoutH">

                <TextView
                    android:id="@+id/heading"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:textSize="15sp"
                    android:textStyle="bold"
                    android:padding="10dp"
                    android:layout_marginTop="10dp"
                    android:layout_weight="1"/>

                <TextView
                    android:id="@+id/code"
                    android:layout_weight="1"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="44dp"
                    android:text="asgfdaac" />
            </LinearLayout>
            ```
        """.trimIndent()
        val markwon = Markwon.builder(requireContext()).build()
        markwon.setMarkdown(code, md)
        return myFragmentView
    }


}