package `in`.iot.lab.acl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.noties.markwon.Markwon


class NestedScrollViewFrag : Fragment() {

    lateinit var code: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_nested_scroll_view, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            NestedScrollView is just like ScrollView, but it supports acting as both a nested scrolling parent and child on both new and old versions of Android. It is enabled by default. NestedScrollView is used when there is a need for a scrolling view inside another scrolling view. You have seen this in many apps for example when we open a pdf file and when we reached the end of the PDF there is an Ad below the pdf file. This is where NestedScrollView comes in.
    #XML
    ```xml
       <ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".NestedScrollViewFrag">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="20dp"
        android:gravity="center"
        android:orientation="vertical">

        <androidx.core.widget.NestedScrollView
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:layout_margin="20dp"
            android:background="@android:color/white"
            android:padding="10dp">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/nested_scroll_text"/>

            </LinearLayout>

        </androidx.core.widget.NestedScrollView>

        <ImageView
            android:layout_width="45dp"
            android:layout_height="45dp"
            android:layout_marginBottom="20dp"
            android:src="@drawable/acl_logo"/>

        <ImageView
            android:layout_width="45dp"
            android:layout_height="45dp"
            android:layout_marginBottom="20dp"
            android:src="@drawable/acl_logo"/>

        <ImageView
            android:layout_width="45dp"
            android:layout_height="45dp"
            android:layout_marginBottom="20dp"
            android:src="@drawable/acl_logo"/>

        <ImageView
            android:layout_width="45dp"
            android:layout_height="45dp"
            android:layout_marginBottom="20dp"
            android:src="@drawable/acl_logo"/>

        <ImageView
            android:layout_width="45dp"
            android:layout_height="45dp"
            android:layout_marginBottom="20dp"
            android:src="@drawable/acl_logo"/>

        <ImageView
            android:layout_width="45dp"
            android:layout_height="45dp"
            android:layout_marginBottom="20dp"
            android:src="@drawable/acl_logo"/>
    <TextView
        android:id="@+id/code"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="@string/hello_blank_fragment" />

    </LinearLayout>

</ScrollView>
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}