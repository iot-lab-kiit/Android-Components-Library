package `in`.iot.lab.acl.button

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class FloatingActionButtonFrag : Fragment() {
    lateinit var code: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView =
            inflater.inflate(R.layout.fragment_floating_action_button, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/add_fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:src="@drawable/add"
        app:fabSize="normal" />
    ```
    #Kotlin
    ```kotlin
    val bttn=findViewById<FloatingActionButton>(R.id.add_fab)
    //To Set button and do other action
    bttn.setOnCheckedChangeListener{ 
        //Do all you want to do here
    }
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}