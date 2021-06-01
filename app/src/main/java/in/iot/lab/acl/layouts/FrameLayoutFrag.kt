package `in`.iot.lab.acl.layouts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.iot.lab.acl.R
import android.widget.TextView
import io.noties.markwon.Markwon

class FrameLayoutFrag : Fragment() {
    lateinit var code: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView= inflater.inflate(`in`.iot.lab.acl.R.layout.fragment_frame_layout, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)

        val md = """
            #XML
            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".layouts.FrameLayoutFrag">

                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:src="@drawable/acl_logo"/>

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="@string/hello_Coders"
                    android:layout_gravity="center_vertical"
                    android:textAlignment="center"
                    android:textStyle="bold"
                    android:textSize="40sp"
                    android:textColor="@color/black"
                    tools:ignore="RtlCompat" />
            </FrameLayout>
            ```
        """.trimIndent()
        val markwon = Markwon.builder(requireContext()).build()
        markwon.setMarkdown(code, md)
        return myFragmentView
    }


}