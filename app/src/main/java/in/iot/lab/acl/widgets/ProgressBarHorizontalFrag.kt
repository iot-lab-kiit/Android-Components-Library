package `in`.iot.lab.acl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.noties.markwon.Markwon

class ProgressBarHorizontalFrag : Fragment() {


    lateinit var code: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_progress_bar_horizontal, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
         <ProgressBar
        android:id="@+id/progressHorizontal"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:layout_marginTop="20dp"
        style="@style/Widget.AppCompat.ProgressBar.Horizontal"/>
    ```
    #Kotlin
    ```kotlin
    val progressbar=findViewById<ProgressBar>(R.id.progressHorizontal)
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}