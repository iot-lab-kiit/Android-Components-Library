package `in`.iot.lab.acl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import io.noties.markwon.Markwon


class ScrollViewFrag : Fragment() {

    lateinit var code: TextView
    lateinit var spinner: Spinner
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_scroll_view, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)


        val md = """
            ScrollView is a view group that is used to make vertically scrollable views. A scroll view contains a single direct child only. In order to place multiple views in the scroll view, one needs to make a view group(like LinearLayout) as a direct child and then we can define many views inside it. A ScrollView supports Vertical scrolling only.
    #XML
    ```xml
    
        <ScrollView
        android:layout_width="match_parent"
        android:layout_height="300dp">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="vertical">
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
    </ScrollView>
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}