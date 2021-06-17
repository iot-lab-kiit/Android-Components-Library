package `in`.iot.lab.acl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import io.noties.markwon.Markwon


class HorizontalScrollVewFrag : Fragment() {

    lateinit var code: TextView
    lateinit var spinner: Spinner
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_horizontal_scroll_vew, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)


        val md = """
            A HorizontalScrollView is a FrameLayout. The android.widget.HorizontalScrollView class provides the functionality of horizontal scroll view. HorizontalScrollView is used to scroll the child elements or views in a horizontal direction. HorizontalScrollView only supports horizontal scrolling.
    #XML
    ```xml
    
        <HorizontalScrollView
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal">
            <TextView
                android:padding="45dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Item 1"/>
            <TextView
                android:padding="45dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Item 2"/>
            <TextView
                android:padding="45dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Item 3"/>
            <TextView
                android:padding="45dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Item 4"/>
            <TextView
                android:padding="45dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Item 5"/>
            <TextView
                android:padding="45dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Item 6"/>
            <TextView
                android:padding="45dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Item 7"/>
        </LinearLayout>
    </HorizontalScrollView>
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}