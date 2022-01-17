package `in`.iot.lab.acl.layouts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.iot.lab.acl.R
import android.widget.TextView
import io.noties.markwon.Markwon


class TableLayoutFrag : Fragment() {
    lateinit var code: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView= inflater.inflate(R.layout.fragment_table_layout, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)

        val md = """
            #XML
            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".layouts.TableLayoutFrag">

                <TableRow
                    android:layout_width="fill_parent"
                    android:layout_height="fill_parent">

                    <TextView
                        android:text="Time"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_column="1" />

                    <TextClock
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:id="@+id/textClock"
                        android:layout_column="2" />

                </TableRow>

                <TableRow>
    
                    <TextView
                        android:text="First Name"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_column="1" />

                    <EditText
                        android:width="200px"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content" />
                </TableRow>

                <TableRow>
        
                    <TextView
                        android:text="Last Name"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_column="1" />

                    <EditText
                        android:width="100px"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content" />
                </TableRow>
    
                <TableRow
                    android:layout_width="fill_parent"
                    android:layout_height="fill_parent">
                    
                    <Button
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Submit"
                        android:id="@+id/button"
                        android:layout_column="3" />
                </TableRow>
            </TableLayout>
            ```
        """.trimIndent()
        val markwon = Markwon.builder(requireContext()).build()
        markwon.setMarkdown(code, md)
        return myFragmentView
    }


}