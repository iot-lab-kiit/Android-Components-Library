package `in`.iot.lab.acl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.noties.markwon.Markwon


class ProgressBarSpiralFrag : Fragment() {

    lateinit var code: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_progress_bar_spiral, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
         <ProgressBar
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:layout_gravity="center"/>
    ```
    #Kotlin
    ```kotlin
    val progressbar=findViewById<ProgressBar>(R.id.progressSpiral)
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}