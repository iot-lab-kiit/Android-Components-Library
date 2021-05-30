package `in`.iot.lab.acl.text

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class Toast : Fragment() {
    lateinit var codeView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val myFragmentView= inflater.inflate(R.layout.fragment_toast, container, false)
        codeView = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            #Kotlin
            ```Kotlin
            Toast.makeText(requireContext(),"Message",Toast.LENGTH_LONG).show()
            ```
            
            
            #JAVA
            ```java
            Toast.makeText(this,"Message",Toast.LENGTH_LONG).show();
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()



        markwon.setMarkdown(codeView, md)
        return myFragmentView

    }


}